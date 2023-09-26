package com.example.service;

import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import com.example.repository.LogRepository;
import com.example.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final LogRepository logRepository;
    private final LogService logService;

    @Transactional
    public MovieResponse getMovie(long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        return MovieResponse.of(movie);
    }

    public List<MovieResponse> getMovies() {
        List<Movie> movies = movieRepository.findByProductionYear(2020);
        return movies.stream().map(MovieResponse::of).toList();
    };

    @Transactional
    public void saveMovie(MovieRequest movieRequest) {
        Movie movie1 = new Movie(movieRequest.getName() + "1", movieRequest.getProductionYear());
        movieRepository.save(movie1);
        logService.saveLog();
    }

    @Transactional
    public void updateMovie(long movieId, MovieRequest movieRequest) {
        //조회가 되는 순간 write 쿼리가 안먹음
        Movie movie = movieRepository.findById(movieId).orElseThrow();

        movie.setName("변경1"); //이름 변경 -> dirty checking
        movie.setName("변경2");
        movie.setName("변경3");
    }

    public void removeMovie(long movieId, MovieRequest movieRequest) {
    }

}
