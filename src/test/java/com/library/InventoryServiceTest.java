package com.library;

import com.library.model.Book;
import com.library.service.InventoryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {

    private InventoryService inventoryService;

    @BeforeEach
    void setup() {

        inventoryService =
                new InventoryService();
    }

    @Test
    void shouldAddBookSuccessfully() {

        Book book =
                new Book(
                        "101",
                        "Clean Code",
                        "Robert Martin",
                        2008
                );

        inventoryService.addBook(book);

        assertEquals(
                1,
                inventoryService.getAllBooks().size()
        );
    }

    @Test
    void shouldRemoveBookSuccessfully() {

        Book book =
                new Book(
                        "101",
                        "Clean Code",
                        "Robert Martin",
                        2008
                );

        inventoryService.addBook(book);

        inventoryService.removeBook("101");

        assertEquals(
                0,
                inventoryService.getAllBooks().size()
        );
    }

    @Test
    void shouldThrowExceptionWhenTitleBlank() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Book(
                        "101",
                        "",
                        "Author",
                        2020
                )
        );
    }
}