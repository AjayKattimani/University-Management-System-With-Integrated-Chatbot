package com.exam.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.exam.spring")
@EnableJpaRepositories(basePackages = "com.exam.spring")
@EntityScan(basePackages = "com.exam.spring")
public class UniversityManagementSystemProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversityManagementSystemProjectApplication.class, args);
    }
}