package com.Ex;

public class UserProfile {

    private NotificationService notificationService;

    public void setNotificationService(
            NotificationService notificationService) {

        this.notificationService = notificationService;
    }

    public void sendNotification() {

        notificationService.sendNotification();
    }
}