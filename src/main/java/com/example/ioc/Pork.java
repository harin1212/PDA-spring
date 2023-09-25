package com.example.ioc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Pork implements Ingredient{
    private final String name; //OCP 원칙
    //name 변경은 Pork에서 직접 하지않고 setter 이용
}
