package com.example.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor  // 디폴트 생성자 추가
public class MovieRequest {
    private String name;
    private Integer productionYear;
}
