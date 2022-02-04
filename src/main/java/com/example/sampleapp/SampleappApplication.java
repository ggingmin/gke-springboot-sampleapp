package com.example.sampleapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SampleappApplication {

    @Value("${TARGET:World}")
    String target;

    @RestController
    class SampleController {
            @GetMapping("/")
            String sample() {
                    return "본 Spring Boot 어플리케이션은 GKE 클러스터에 배포되었습니다.";
            }
    }

    public static void main(String[] args) {
            SpringApplication.run(SampleappApplication.class, args);
    }

}
