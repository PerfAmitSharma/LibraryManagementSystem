package com.library;

import com.library.factory.SearchType;
import com.library.model.Book;
import com.library.model.Patron;
import com.library.service.InventoryService;
import com.library.service.LendingService;
import com.library.service.SearchService;

public class Main {

    public static void main(String[] args) {

        InventoryService inventoryService =
                new InventoryService();

        LendingService lendingService =
                new LendingService();

        SearchService searchService =
                new SearchService();

        Book book1 =
                new Book(
                        "101",
                        "Clean Code",
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

        inventoryService.addBook(book1);
        inventoryService.addBook(book2);

        Patron patron =
                new Patron(
                        "P1",
                        "Amit"
                );

        lendingService.checkoutBook(
                book1,
                patron
        );

        System.out.println(
                "Book borrowed successfully"
        );

        var results =
                searchService.searchBooks(
                        inventoryService.getAllBooks(),
                        SearchType.TITLE,
                        "Clean Code"
                );

        System.out.println(
                "Search Results: "
                        + results.size()
        );
    }
}