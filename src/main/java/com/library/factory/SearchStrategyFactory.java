package com.library.factory;

import com.library.strategy.AuthorSearchStrategy;
import com.library.strategy.SearchStrategy;
import com.library.strategy.TitleSearchStrategy;

public class SearchStrategyFactory {

    public static SearchStrategy getStrategy(
            SearchType type) {

        return switch (type) {

            case TITLE ->
                    new TitleSearchStrategy();

            case AUTHOR ->
                    new AuthorSearchStrategy();
        };
    }
}