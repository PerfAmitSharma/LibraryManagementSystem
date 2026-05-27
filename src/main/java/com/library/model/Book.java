package com.library.model;

import com.library.util.ValidationUtil;

public class Book {

    private final String isbn;

    private String title;

    private String author;

    private int publicationYear;

    private boolean available;

    public Book(String isbn,
                String title,
                String author,
                int publicationYear) {

        ValidationUtil.validateNotBlank(
                isbn,
                "ISBN"
        );

        ValidationUtil.validateNotBlank(
                title,
                "Title"
        );

        ValidationUtil.validateNotBlank(
                author,
                "Author"
        );

        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}