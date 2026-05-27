package com.library.strategy;

import com.library.model.Book;

import java.util.List;

public class TitleSearchStrategy
        implements SearchStrategy {

    @Override
    public List<Book> search(
            List<Book> books,
            String keyword) {

        return books.stream()
                .filter(book ->
                        book.getTitle()
                                .equalsIgnoreCase(keyword))
                .toList();
    }
}