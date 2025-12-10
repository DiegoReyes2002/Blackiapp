package com.braki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BrakiAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(BrakiAppApplication.class, args);
        System.out.println("✅ Braki App v3 iniciada en http://localhost:8080");
    }
}
