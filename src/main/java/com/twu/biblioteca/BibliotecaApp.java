package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private Library library;
    private ReadWriteOperation operation;

    public BibliotecaApp(ReadWriteOperation operation, Library library) {

        this.operation = operation;
        this.library = library;
    }

    public static void main(String[] args) {
        ReadWriteOperation operation = new ReadWriteOperation();
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("TDD By Example", "Kent Beck", "2000"), new Book("Clean Code", "Robert C. Martin", "2008")));
        List<Movie> movieList = new ArrayList<>(Arrays.asList(new Movie("Harry Potter 1", "2001", "Chris Columbus", Rating.UNRATED), new Movie("Harry Potter 2", "2003", "Chris Columbus", Rating.TEN)));
        Library library = new Library(bookList, movieList, new Librarian(), new ReadWriteOperation(), new ArrayList<>());
        new BibliotecaApp(operation, library).start();
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
                    String checkOutBook = operation.userItemName();
                    library.checkOut(checkOutBook);
                    break;
                case "3":
                    String returnBook = operation.userItemName();
                    library.returnBook(returnBook);
                    break;
                case "4":
                    library.displayMovies();
                    break;
                case "5":
                    String checkOutMovie = operation.userItemName();
                    library.checkOutMovie(checkOutMovie);
                    break;
                case "6":
                    String returnMovie = operation.userItemName();
                    library.returnMovie(returnMovie);
                    break;
                case "0":
                    status = false;
                    break;
                default:
                    operation.display(Constants.INVALID_MESSAGE);
                    break;
            }
        }
    }

    private void displayMenu() {
        Menu menu = new Menu(operation);
        menu.displayOptions();
    }

    private void displayMessage() {
        operation.display(Constants.WELCOME_MESSAGE);
    }

    private void displayLibraryBooks() {
        library.displayBooks();
    }
}
