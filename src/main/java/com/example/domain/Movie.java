package com.example.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Movie {
    private final long id;
    private final String name;
    private final Integer productionYear;
}
