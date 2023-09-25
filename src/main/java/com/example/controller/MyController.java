package com.example.controller;

import com.example.config.MyConfig;
import com.example.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private final MyService myService;
    private final MyConfig myConfig;

    @Autowired
    public MyController(MyService myService, MyConfig myConfig){
        this.myService = myService;
        this.myConfig = myConfig;
    }
}
