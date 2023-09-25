package com.example.ioc;

import com.example.config.MyConfig;
import com.example.config.MyConfigProto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PrintBeans {
    //의존성 주입의 대상
//    @Autowired
    private final ApplicationContext applicationContext; //IoC 컨테이너의 구현체
    private final MyConfig myConfig;
    private final MyConfigProto myConfigProto;

    @Bean
    public void printBeansMethod(){
        List<String> beans = Arrays.stream(applicationContext.getBeanDefinitionNames()).toList();

        for(String beanName: beans){
            System.out.println(beanName);
        }
        System.out.println();
    }
}
