package com.twu.biblioteca;

import java.util.Objects;

class Book {
    private final String name;
    private final String author;
    private final String year;

    public Book(String name, String author, String year) {

        this.name = name;
        this.author = author;
        this.year = year;
    }

    void displayInformation() {
        System.out.println(name + " | " + author + " | " + year);
    }

    public boolean isName(String bookName) {
        return bookName.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, year);
    }
}
