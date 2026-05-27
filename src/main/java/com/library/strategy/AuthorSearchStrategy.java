package com.library.strategy;

import com.library.model.Book;

import java.util.List;

public class AuthorSearchStrategy
        implements SearchStrategy {

    @Override
    public List<Book> search(
            List<Book> books,
            String keyword) {

        return books.stream()
                .filter(book ->
                        book.getAuthor()
                                .equalsIgnoreCase(keyword))
                .toList();
    }
}