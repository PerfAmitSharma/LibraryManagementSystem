package com.library.observer;

public class AppNotification
        implements NotificationObserver {

    @Override
    public void notifyUser(String message) {

        System.out.println(
                "APP ALERT: " + message
        );
    }
}