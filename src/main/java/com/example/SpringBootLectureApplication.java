package com.example;

import com.example.config.MyConfig;
import com.example.config.MyConfigProto;
import com.example.ioc.Chef;
import com.example.ioc.IngredientFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLectureApplication {

    public static void main(String[] args) {


        //스프링 기동
        SpringApplication.run(SpringBootLectureApplication.class, args);



//        IngredientFactory ingredientFactory = new IngredientFactory();
//        Chef chef = new Chef(ingredientFactory);
//
//        String food = chef.cook("스테이크");
//        System.out.println(food);
    }
}
