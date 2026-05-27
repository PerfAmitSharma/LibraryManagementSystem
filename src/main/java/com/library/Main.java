package com.library;

import com.library.factory.SearchType;

import com.library.model.Book;
import com.library.model.Patron;

import com.library.observer.AppNotification;
import com.library.observer.EmailNotification;

import com.library.service.InventoryService;
import com.library.service.LendingService;
import com.library.service.NotificationService;
import com.library.service.SearchService;

public class Main {

    public static void main(String[] args) {

        // SERVICES

        InventoryService inventoryService =
                new InventoryService();

        LendingService lendingService =
                new LendingService();

        SearchService searchService =
                new SearchService();

        NotificationService notificationService =
                new NotificationService();

        // REGISTER OBSERVERS

        notificationService.addObserver(
                new EmailNotification()
        );

        notificationService.addObserver(
                new AppNotification()
        );

        // CREATE BOOKS

        Book book1 =
                new Book(
                        "101",
                        "Effective Code",
                        "Robert Martin",
                        2008
                );

        Book book2 =
                new Book(
                        "102",
                        "Effective Java",
                        "Joshua Bloch",
                        2018
                );

        // ADD BOOKS TO INVENTORY

        inventoryService.addBook(book1);

        inventoryService.addBook(book2);

        // CREATE PATRON

        Patron patron =
                new Patron(
                        "P1",
                        "Amit"
                );

        // CHECKOUT BOOK

        lendingService.checkoutBook(
                book1,
                patron
        );

        System.out.println(
                "Book borrowed successfully"
        );

        // SEND NOTIFICATION

        notificationService.notifyAllObservers(
                "Book borrowed: "
                        + book1.getTitle()
        );

        // SEARCH BOOKS

        var results =
                searchService.searchBooks(
                        inventoryService.getAllBooks(),
                        SearchType.TITLE,
                        "Clean Code"
                );

        System.out.println(
                "Search Results Found: "
                        + results.size()
        );

        // RETURN BOOK

        lendingService.returnBook(book1);

        System.out.println(
                "Book returned successfully"
        );

        // NOTIFY AFTER RETURN

        notificationService.notifyAllObservers(
                "Book returned: "
                        + book1.getTitle()
        );
    }
}