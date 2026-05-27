package com.library.observer;

public class EmailNotification
        implements NotificationObserver {

    @Override
    public void notifyUser(String message) {

        System.out.println(
                "EMAIL SENT: " + message
        );
    }
}