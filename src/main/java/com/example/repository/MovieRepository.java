package com.example.repository;

import com.example.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Long>{
    @Query("SELECT distinct m from Movie m left join fetch m.actors a left join fetch m.director d")
    //List<Movie> findAllJpqlFetch();

    //functional하게 jpa 만들기
    List<Movie> findByProductionYear(int productionYear);

}
