package com.example.controller;

import com.example.domain.request.UserRequest;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/v1/user/join")
    public void join(
            @RequestBody UserRequest userRequest
            ){
        userService.join(userRequest);
    }
}
