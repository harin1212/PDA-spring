package com.example.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "director_id")
    private Director director;

    //actor
    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER) //키의 주인, fetch : 기본 LAZY로 되므로 EAGER로 변경
    private List<Actor> actors;

    public Movie(String name, int productionYear){
        this.name = name;
        this.productionYear = productionYear;
    }

}
