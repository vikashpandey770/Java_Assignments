package com.Ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        PlaylistService playlistService =
                context.getBean(PlaylistService.class);

        playlistService.showDependecy();

        RecommendationService recommendationService =
                context.getBean(RecommendationService.class);

        System.out.println("All Spring beans loaded successfully");
    }
}