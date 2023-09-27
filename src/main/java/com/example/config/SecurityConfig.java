package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //security 허용하겠다
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity
                .csrf().disable() //JWT로 하려고 끄기
                .formLogin()
                //.usernameParameter("userId") //이걸로 매핑시켜야 데이터 넘어옴
                .defaultSuccessUrl("/home")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");

        /**
         * 권한 설정
         */
        return httpSecurity
                .authorizeRequests(auth ->
                        auth.antMatchers("/api/v1/user/join", "/login").permitAll() //secure된 url. 모두 접근 가능
                                .antMatchers("/admin").hasRole("ADMIN") //role, DB에서 ROLE_ADMIN
                                .antMatchers("/manager").access("hasRole('ADMIN') or hasRole('MANAGER')") //여러면 접근 가능하게
                                .anyRequest().authenticated() //다른 요청은 권한을 가져라
                )
                .build();
    }

    //암호화
    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}