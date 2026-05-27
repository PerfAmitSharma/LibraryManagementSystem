package com.library.model;

import com.library.util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;

public class Patron {

    private final String id;

    private final String name;

    private final List<LoanRecord> borrowingHistory =
            new ArrayList<>();

    public Patron(String id, String name) {

        ValidationUtil.validateNotBlank(
                id,
                "Patron ID"
        );

        ValidationUtil.validateNotBlank(
                name,
                "Patron Name"
        );

        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<LoanRecord> getBorrowingHistory() {
        return borrowingHistory;
    }
}