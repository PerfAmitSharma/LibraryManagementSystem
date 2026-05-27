package com.library.service;

import com.library.factory.SearchStrategyFactory;
import com.library.factory.SearchType;
import com.library.model.Book;
import com.library.strategy.SearchStrategy;

import java.util.List;

public class SearchService {

    public List<Book> searchBooks(
            List<Book> books,
            SearchType type,
            String keyword) {

        SearchStrategy strategy =
                SearchStrategyFactory
                        .getStrategy(type);

        return strategy.search(
                books,
                keyword
        );
    }
}