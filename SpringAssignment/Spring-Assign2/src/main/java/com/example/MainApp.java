package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "applicationContext.xml");

        PlaylistService playlistService =
                context.getBean(
                        "playlistService",
                        PlaylistService.class);

        playlistService.showPlaylist();


        OrderService orderService =
                context.getBean(
                        "orderService",
                        OrderService.class);

        orderService.placeOrder();
    }
}