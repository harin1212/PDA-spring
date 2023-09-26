package com.example.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="movie")
@Getter
@Setter
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

    //id가 아닌 객체와의 매핑
    //director movie와 일대일 관계 맺어짐
    @OneToOne
    @JoinColumn(name = "director_id")
    private Director director;

    public Movie(String name, int productionYear){
        this.name = name;
        this.productionYear = productionYear;
    }

}
