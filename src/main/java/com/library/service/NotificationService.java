package com.library.service;

import com.library.observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private final List<NotificationObserver>
            observers =
            new ArrayList<>();

    public void addObserver(
            NotificationObserver observer) {

        observers.add(observer);
    }

    public void notifyAllObservers(
            String message) {

        for(NotificationObserver observer
                : observers) {

            observer.notifyUser(message);
        }
    }
}