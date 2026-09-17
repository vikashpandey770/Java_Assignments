package com.Ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApps {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "applicationContext.xml");


        // TASK 1
        System.out.println("----- TASK 1 -----");

        Playlist playlist =
                context.getBean("playlist", Playlist.class);

        Song song =
                context.getBean("song", Song.class);

        System.out.println("Playlist Name: "
                + playlist.getName());

        System.out.println("Song Title: "
                + song.getTitle());

        System.out.println("Artist: "
                + song.getArtist());


        // TASK 2
        System.out.println("\n----- TASK 2 -----");

        UserSession session1 =
                context.getBean("UserSession",
                        UserSession.class);

        UserSession session2 =
                context.getBean("UserSession",
                        UserSession.class);

        System.out.println(
                "UserSession same? "
                + (session1 == session2)
        );

        System.out.println(
                "Session 1 HashCode: "
                + System.identityHashCode(session1)
        );

        System.out.println(
                "Session 2 HashCode: "
                + System.identityHashCode(session2)
        );


        AppConfig config1 =
                context.getBean("AppConfig",
                        AppConfig.class);

        AppConfig config2 =
                context.getBean("AppConfig",
                        AppConfig.class);

        System.out.println(
                "AppConfig same? "
                + (config1 == config2)
        );
        System.out.println(
                "Config 1 HashCode: "
                + System.identityHashCode(config1)
        );
        System.out.println(
                "Config 2 HashCode: "
                + System.identityHashCode(config2)
        );
        System.out.println("\n----- TASK 3 -----");
        FoodOrder foodOrder =
                context.getBean("FoodOrder",
                        FoodOrder.class);
        System.out.println(
                "Order ID: "
                + foodOrder.getOrderId()
        );
        System.out.println(
                "Delivery Address: "
                + foodOrder.getDeliveryDetails().getAddress()
        );
        System.out.println("\n----- TASK 4 -----");
        UserProfile userProfile =
                context.getBean("UserProfile",
                        UserProfile.class);
        userProfile.sendNotification();
    }
}