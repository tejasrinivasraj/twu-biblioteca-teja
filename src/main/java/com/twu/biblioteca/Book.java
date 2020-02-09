package com.twu.biblioteca;

class Book {
    private final String name;
    private final String author;
    private final String year;

    public Book(String name, String author, String year) {

        this.name = name;
        this.author = author;
        this.year = year;
    }

    void displayName() {
        System.out.println(name);
    }

    void displayInformation() {
        System.out.println(name + " | " + author + " | " + year);
    }

    public boolean isName(String bookName) {
        return bookName.equals(name);
    }
}
