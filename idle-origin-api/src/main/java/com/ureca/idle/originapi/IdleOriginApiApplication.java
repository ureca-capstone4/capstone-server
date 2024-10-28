package com.ureca.idle.originapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.ureca.idle.jpa")
@ComponentScan(basePackages = "com.ureca.idle.aiclient")
public class IdleOriginApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdleOriginApiApplication.class, args);
    }
}


