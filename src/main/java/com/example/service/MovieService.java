package com.example.service;

import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final EntityManagerFactory emf;

    public MovieResponse getMovie(long movieId) {
        EntityManager entityManager = emf.createEntityManager();
        Movie movie = entityManager.find(Movie.class, movieId);
        return MovieResponse.of(movie);
    }

    public List<MovieResponse> getMovies(Integer overYear) {
        return List.of();
    };

    public void saveMovie(MovieRequest movieRequest) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            Movie movie = new Movie(movieRequest.getName(), movieRequest.getProductionYear());
            if(movie != null){
                throw new RuntimeException("강제 오류 처리");
            }

            entityManager.persist(movie);
            entityManager.flush();

            tx.commit();

            //throw new RuntimeException("roll back");
        }catch (Exception e){
            tx.rollback();
        }

    }

    public void updateMovie(long movieId, MovieRequest movieRequest) {

    }

    public void deleteMovie(long movieId, MovieRequest movieRequest) {

    }

}
