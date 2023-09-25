package com.example.domain.response;

import com.example.domain.entity.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
public class MovieResponse {
    private final long id;
    private final String name;
    private final Integer productionYear;

    public static MovieResponse of(Movie movie) {
        return MovieResponse.builder()
                .id(movie.getId())
                .name(movie.getName())
                .productionYear(movie.getProductionYear())
                .build();
    }
}
