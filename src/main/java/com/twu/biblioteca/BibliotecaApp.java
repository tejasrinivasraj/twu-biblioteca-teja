package com.twu.biblioteca;

import com.twu.biblioteca.Exception.QuitMenuException;

import java.util.*;

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
        HashMap<String, Choice> menu = new HashMap<>(Map.of("1", new ListBooks(), "2", new ListMovies(), "3", new CheckoutBook(), "4", new ReturnBook(), "5", new CheckoutMovie(), "6", new ReturnMovie(), "0", new Quit()));
        boolean status = true;
        while (status) {
            displayMenu();
            String choice = operation.userChoice();
            Choice userChoice = menu.containsKey(choice) ? menu.get(choice) : new Invalid();
            try {
                userChoice.perform(library, operation);
            } catch (QuitMenuException e) {
                status = false;
            }
        }
    }

    private void displayMenu() {
        Menu menu = new Menu(operation);
        menu.defaultOptions();
    }

    private void displayMessage() {
        operation.display(Constants.WELCOME_MESSAGE);
    }
}
