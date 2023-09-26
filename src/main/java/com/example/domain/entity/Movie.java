package com.example.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="movie")
@Getter
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "production_year")
    private Integer productionYear;

    @Column(name = "created_at")
    private LocalDateTime createAt=LocalDateTime.now();

    public Movie(String name, int productionYear){
        this.name = name;
        this.productionYear = productionYear;
    }

}
