package com.example.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BaseTest {
    @Test
    @DisplayName("더하기 테스트")
    public void calTest(){
        //given
        int a = 1;
        int b = 3;

        //when
        int sum = a+b;

        //then
        assertEquals(3, sum);
    }
}
