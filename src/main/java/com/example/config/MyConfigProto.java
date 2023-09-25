package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") //실무에서 잘 사용 안함
public class MyConfigProto {
    @Bean
    public void configProto(){}
}
