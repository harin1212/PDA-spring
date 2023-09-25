package com.example.controller;

import com.example.config.MyConfig;
import com.example.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

@RestController //@ResponseBody가 포함됨
public class MyController {
    private final MyService myService;
    private final MyConfig myConfig;

    //생성자 주입
    @Autowired
    public MyController(MyService myService, MyConfig myConfig){
        this.myService = myService;
        this.myConfig = myConfig;
    }


}