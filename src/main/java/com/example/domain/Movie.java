package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor //final 없는 애들도 모아서 생성자 만들어줌
@Getter
@Setter
public class Movie {
    private long id;
    private String name;
    private Integer productionYear;
}
