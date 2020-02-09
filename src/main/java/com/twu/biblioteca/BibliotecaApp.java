package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private ReadOperation operation;

    public BibliotecaApp(ReadOperation operation) {

        this.operation = operation;
    }

    public static void main(String[] args) {
        ReadOperation readOperation = new ReadOperation();
        new BibliotecaApp(readOperation).start();
    }

    void start() {
        displayMessage();
        displayMenu();
        String choice = operation.userChoice();
        if (choice.equals("1"))
            displayLibraryBooks();
        else if (choice.equals("0"))
            quit();
        else
            System.out.println(Constants.INVALID_MESSAGE);
    }

    private void quit() {
        System.exit(0);
    }

    private void displayMenu() {
        Menu menu = new Menu();
        menu.displayOptions();
    }

    private void displayMessage() {
        System.out.println(Constants.WELCOME_MESSAGE);
    }

    private void displayLibraryBooks() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("TDD By Example", "Kent Beck", "2000"), new Book("Clean Code", "Robert C. Martin", "2008")));
        Library library = new Library(bookList);
        library.displayBooks();
    }
}
