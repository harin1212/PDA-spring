package com.example.service;

import com.example.domain.entity.User;
import com.example.domain.request.UserRequest;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void join(UserRequest userRequest) {
        User user = new User(
                userRequest.getUsername(),
                userRequest.getPassword(),
                userRequest.getRole()
        );
        userRepository.save(user);
    }
}