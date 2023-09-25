package com.example.ioc;

import lombok.*;

@Getter
@Setter
//@NoArgsConstructor //default 생성자
//@AllArgsConstructor //모든 변수의 생성자
@RequiredArgsConstructor
public class Chicken implements Ingredient{
    final String name;
}
