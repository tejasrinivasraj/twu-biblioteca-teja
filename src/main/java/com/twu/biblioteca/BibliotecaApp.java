package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayMessage();
        bibliotecaApp.displayBooks();
    }

    private void displayMessage() {
        System.out.println(Constants.welcomeMessage);
    }

    private void displayBooks() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("TDD By Example"), new Book("Clean Code")));
        for (Book book : bookList) {
            book.displayName();
        }
    }
}
