package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    private void start() {
        displayMessage();
        displayLibraryBooks();
    }

    private void displayMessage() {
        System.out.println(Constants.welcomeMessage);
    }

    private void displayLibraryBooks() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("TDD By Example"), new Book("Clean Code")));
        Library library = new Library(bookList);
        library.displayBooks();
    }
}
