package com.eshop.serviceweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.eshop.serviceweb.mapper")
public class ServiceWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceWebApplication.class, args);
    }
}
