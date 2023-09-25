package com.example.common;

import lombok.RequiredArgsConstructor;

//매핑용 response 개체
@RequiredArgsConstructor
public class ExceptionResponse {
    private final String message;
    private final int code;
}
