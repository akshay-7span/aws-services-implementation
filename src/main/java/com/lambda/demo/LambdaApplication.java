package com.lambda.demo;

import com.lambda.demo.controller.PingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
public class LambdaApplication {
    public static void main(String[] args) {
        SpringApplication.run(LambdaApplication.class, args);
    }
}