package com.example.domain.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class MovieRequest {
    private final String name;
    private final Integer productionYear;
}
