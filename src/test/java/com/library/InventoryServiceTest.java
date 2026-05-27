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
}