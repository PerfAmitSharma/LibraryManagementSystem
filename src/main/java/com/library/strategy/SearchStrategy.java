package com.library.strategy;

import com.library.model.Book;

import java.util.List;

public interface SearchStrategy {

    List<Book> search(
            List<Book> books,
            String keyword
    );
}