package com.library.service;

import com.library.exception.BookNotFoundException;
import com.library.model.Book;
import com.library.util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;

public class InventoryService {

    private final List<Book> books =
            new ArrayList<>();

    public void addBook(Book book) {

        ValidationUtil.validateNotNull(
                book,
                "Book"
        );

        books.add(book);
    }

    public void removeBook(String isbn) {

        Book foundBook = books.stream()
                .filter(book ->
                        book.getIsbn()
                                .equals(isbn))
                .findFirst()
                .orElseThrow(() ->
                        new BookNotFoundException(
                                "Book not found with ISBN: "
                                        + isbn
                        )
                );

        books.remove(foundBook);
    }

    public List<Book> getAllBooks() {
        return books;
    }
}