package com.example.service;

import com.example.domain.Movie;
import com.example.domain.request.MovieRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private static List<Movie> movies = new ArrayList<>();

    @PostConstruct
    public void init(){
        movies.addAll(List.of(
                new Movie(1, "엘리멘탈",2023),
                new Movie(2, "소울",2020),
                new Movie(3, "엔칸토",1999)
        ));
    }

    public List<Movie> getMovies() {
        return movies;
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
                movieRequest.getProductionYear()
        );
        movies.add(movie); //movie에 할당
    }

    public void updateMovie(long movieId) {
    }

    public void deleteMovie(long movieId) {
    }

}
