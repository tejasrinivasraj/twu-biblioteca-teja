package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List<Book> libraryBooks;

    public Library(List<Book> libraryBooks) {

        this.libraryBooks = libraryBooks;
    }

    public void displayBooks() {
        libraryBooks.forEach(Book::displayName);
    }
}
