package com.example.welcome1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.welcome1.dao")
@SpringBootApplication
public class Welcome1Application {

    public static void main(String[] args) {
        SpringApplication.run(Welcome1Application.class, args);
    }

}
