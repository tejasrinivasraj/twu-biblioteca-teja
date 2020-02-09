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
        System.out.println(Constants.LIST_OF_BOOKS);
        displayLibraryBooks();
    }

    private void displayMessage() {
        System.out.println(Constants.welcomeMessage);
    }

    private void displayLibraryBooks() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("TDD By Example", "Kent Beck", "2000"), new Book("Clean Code", "Robert C. Martin", "2008")));
        Library library = new Library(bookList);
        library.displayBooks();
    }
}
