package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private Library library;
    private ReadOperation operation;

    public BibliotecaApp(ReadOperation operation, Library library) {

        this.operation = operation;
        this.library = library;
    }

    public static void main(String[] args) {
        ReadOperation readOperation = new ReadOperation();
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("TDD By Example", "Kent Beck", "2000"), new Book("Clean Code", "Robert C. Martin", "2008")));
        Library library = new Library(bookList, new Librarian());
        new BibliotecaApp(readOperation, library).start();
    }

    void start() {
        displayMessage();
        boolean status = true;
        while (status) {
            displayMenu();
            String choice = operation.userChoice();
            switch (choice) {
                case "1":
                    displayLibraryBooks();
                    break;
                case "2":
                    String checkOutBook = operation.bookName();
                    library.checkOut(checkOutBook);
                    break;
                case "0":
                    status = false;
                    break;
                default:
                    System.out.println(Constants.INVALID_MESSAGE);
                    break;
            }
        }
    }

    private void displayMenu() {
        Menu menu = new Menu();
        menu.displayOptions();
    }

    private void displayMessage() {
        System.out.println(Constants.WELCOME_MESSAGE);
    }

    private void displayLibraryBooks() {
        library.displayBooks();
    }
}
