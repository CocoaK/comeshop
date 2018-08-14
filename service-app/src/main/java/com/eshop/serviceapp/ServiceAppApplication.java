package com.eshop.serviceapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.eshop.serviceapp.mapper")
public class ServiceAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAppApplication.class, args);
    }
}
