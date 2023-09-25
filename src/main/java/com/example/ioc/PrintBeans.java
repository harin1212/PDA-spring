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
    //의존성 주입의 대상ㅠ
//    @Autowired
    private final ApplicationContext applicationContext; //IoC 컨테이너의 구현체
    private final MyConfig myConfig;
    private final MyConfigProto myConfigProto;

    @Bean
    public void printBeansMethod(){
//        List<String> beans = Arrays.stream(applicationContext.getBeanDefinitionNames()).toList();
//
//        for(String beanName: beans){
//            System.out.println(beanName);
//        }
//        System.out.println();
        MyConfig myConfig1 = applicationContext.getBean(MyConfig.class);
        MyConfig myConfig2 = applicationContext.getBean(MyConfig.class);
        MyConfig myConfig3 = applicationContext.getBean(MyConfig.class);

        MyConfigProto myConfigProto1 = applicationContext.getBean(MyConfigProto.class);
        MyConfigProto myConfigProto2 = applicationContext.getBean(MyConfigProto.class);
        MyConfigProto myConfigProto3 = applicationContext.getBean(MyConfigProto.class);

        System.out.println(myConfig1);
        System.out.println(myConfig2);
        System.out.println(myConfig3);

        System.out.println(myConfigProto1);
        System.out.println(myConfigProto2);
        System.out.println(myConfigProto3);


    }
}
