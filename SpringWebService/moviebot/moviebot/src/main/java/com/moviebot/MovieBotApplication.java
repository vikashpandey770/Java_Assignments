package com.moviebot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieBotApplication.class, args);
        System.out.println("=======================================================");
        System.out.println(" MovieBot is running!");
        System.out.println(" Try: POST http://localhost:8080/askMovieBot");
        System.out.println(" Body: { \"question\": \"Suggest a good sci-fi movie\" }");
        System.out.println("=======================================================");
    }
}
