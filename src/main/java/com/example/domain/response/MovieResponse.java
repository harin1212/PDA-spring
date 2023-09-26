package com.example.domain.response;

import com.example.domain.entity.Movie;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MovieResponse {
    private final long id;
    private final String name;
    private final Integer productionYear;
    private final String directorName;

    public static MovieResponse of(Movie entity) {
        return new MovieResponse(
                entity.getId(),
                entity.getName(),
                entity.getProductionYear(),
                entity.getDirector().getName()
        );
    }
}
