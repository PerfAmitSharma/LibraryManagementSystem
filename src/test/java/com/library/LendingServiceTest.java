package com.library;

import com.library.exception.BookUnavailableException;
import com.library.model.Book;
import com.library.model.Patron;

import com.library.service.LendingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LendingServiceTest {

    private LendingService lendingService;

    @BeforeEach
    void setup() {

        lendingService =
                new LendingService();
    }

    @Test
    void shouldCheckoutBookSuccessfully() {

        Book book =
                new Book(
                        "101",
                        "Clean Code",
                        "Robert Martin",
                        2008
                );

        Patron patron =
                new Patron(
                        "P1",
                        "Amit"
                );

        lendingService.checkoutBook(
                book,
                patron
        );

        assertFalse(book.isAvailable());
    }

    @Test
    void shouldReturnBookSuccessfully() {

        Book book =
                new Book(
                        "101",
                        "Clean Code",
                        "Robert Martin",
                        2008
                );

        Patron patron =
                new Patron(
                        "P1",
                        "Amit"
                );

        lendingService.checkoutBook(
                book,
                patron
        );

        lendingService.returnBook(book);

        assertTrue(book.isAvailable());
    }


    @Test
    void shouldThrowExceptionWhenBookAlreadyBorrowed() {

        Book book =
                new Book(
                        "101",
                        "Clean Code",
                        "Robert Martin",
                        2008
                );

        Patron patron =
                new Patron(
                        "P1",
                        "Amit"
                );

        lendingService.checkoutBook(
                book,
                patron
        );

        assertThrows(
                BookUnavailableException.class,
                () -> lendingService.checkoutBook(
                        book,
                        patron
                )
        );
    }
}