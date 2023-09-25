package com.example.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//매핑용 response 개체
@RequiredArgsConstructor
@Getter
public class ExceptionResponse {
    private final String message;
    private final int code;
}
