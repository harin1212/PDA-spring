package com.example.service;

import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private static List<Movie> movies = new ArrayList<>();

    @PostConstruct
    public void init(){
        movies.addAll(List.of(
                new Movie(1, "엘리멘탈",2023, LocalDateTime.now()),
                new Movie(2, "소울",2020, LocalDateTime.now()),
                new Movie(3, "엔칸토",1999, LocalDateTime.now())
        ));
    }

    public List<MovieResponse> getMovies() {
        return movies.stream().map(movie -> MovieResponse.of(movie)).toList();
        /**
        return movies.stream().map(movie ->
                MovieResponse.builder()
                        .id(movie.getId())
                        .name(movie.getName())
                        .productionYear(movie.getProductionYear())
                        .build()
        ).toList();
         **/
    };

    public Movie getMovie(long movieId){
        return movies.stream()
                .filter(movie -> movie.getId() == movieId)
                .toList()
                .stream()
                .findFirst()
                .orElseThrow(); //Throw : no search exception 발생시킴

    }

    public void createMovie(MovieRequest movieRequest) {
        Movie movie = new Movie(
                movies.size() +1 , //마지막
                movieRequest.getName(),
                movieRequest.getProductionYear(),
                LocalDateTime.now()
        );
        movies.add(movie); //movie에 할당
    }

    public void updateMovie(long movieId, MovieRequest movieRequest) {
        Movie movie = getMovie(movieId);
        movie.setName(movieRequest.getName());
        movie.setProductionYear(movieRequest.getProductionYear());
    }

    public void deleteMovie(long movieId, MovieRequest movieRequest) {
        Movie movie = getMovie(movieId);
        movies.remove(movie);
    }

}
