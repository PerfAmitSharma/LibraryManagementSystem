package com.library.service;

import com.library.model.Book;
import com.library.model.LoanRecord;
import com.library.model.Patron;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LendingService {

    private final List<LoanRecord> loanRecords =
            new ArrayList<>();

    public void checkoutBook(Book book,
                             Patron patron) {

        if(!book.isAvailable()) {

            throw new IllegalArgumentException(
                    "Book already borrowed"
            );
        }

        book.setAvailable(false);

        LoanRecord record =
                new LoanRecord(book, patron);

        loanRecords.add(record);

        patron.getBorrowingHistory()
                .add(record);
    }

    public void returnBook(Book book) {

        book.setAvailable(true);

        for(LoanRecord record : loanRecords) {

            if(record.getBook().equals(book)
                    && record.getReturnDate() == null) {

                record.setReturnDate(
                        LocalDate.now()
                );
            }
        }
    }
}