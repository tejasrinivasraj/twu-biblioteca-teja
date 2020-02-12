package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class BibliotecaAppTest {

    private Library library;
    private ReadWriteOperation operation;

    @BeforeEach
    void setup() {
        operation = mock(ReadWriteOperation.class);
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("TDD By Example", "Kent Beck", "2000"), new Book("Clean Code", "Robert C. Martin", "2008")));
        List<Movie> movieList = new ArrayList<>(Arrays.asList(new Movie("Harry Potter 1", "2001", "Chris Columbus", Rating.UNRATED), new Movie("Harry Potter 2", "2003", "Chris Columbus", Rating.TEN)));
        library = new Library(bookList, movieList, new Librarian(), operation, new ArrayList<>());
    }

    @Test
    void shouldDisplayWelcomeMessageUponStart() {
        doReturn("0").when(operation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(operation, library);

        bibliotecaApp.start();

        verify(operation).display(Constants.WELCOME_MESSAGE);
    }

    @Test
    void shouldDisplayOneBooksIfThereIsOnlyOneBook() {
        doReturn("1", "0").when(operation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(operation, library);

        bibliotecaApp.start();

        verify(operation).display("TDD By Example | Kent Beck | 2000");
    }

    @Test
    void shouldDisplayListOfAllBooksIfThereAreMultipleBooks() {
        doReturn("1", "0").when(operation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(operation, library);

        bibliotecaApp.start();

        verify(operation).display("TDD By Example | Kent Beck | 2000");
        verify(operation).display("Clean Code | Robert C. Martin | 2008");
    }

    @Test
    void shouldDisplayListOfMenuOptions() {
        doReturn("0").when(operation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(operation, library);

        bibliotecaApp.start();

        verify(operation).display(Constants.LIST_OF_BOOKS);
    }

    @Test
    void shouldDisplayListOfBooksIfSelectedMenuOptionIs1() {
        doReturn("1", "0").when(operation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(operation, library);

        bibliotecaApp.start();

        verify(operation).display("TDD By Example | Kent Beck | 2000");
    }

    @Test
    void shouldDisplayInvalidMessageIfSelectedMenuOptionIsNotValid() {
        doReturn("10", "0").when(operation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(operation, library);

        bibliotecaApp.start();

        verify(operation).display(Constants.INVALID_MESSAGE);
    }

    @Test
    void shouldCloseIfSelectedMenuOptionIsQuit() {
        doReturn("0").when(operation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(operation, library);

        bibliotecaApp.start();

        verify(operation, times(0)).display("TDD By Example | Kent Beck | 2000");
    }

    @Test
    void shouldDisplayMenuUntilSelectedOptionIsQuit() {
        doReturn("1", "1", "0").when(operation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(operation, library);

        bibliotecaApp.start();

        verify(operation, times(2)).display("TDD By Example | Kent Beck | 2000");
    }

    @Test
    void shouldCheckOutBookFromLibraryIfSelectedOptionIsCheckOut() {
        doReturn("1", "3", "0").when(operation).userChoice();
        doReturn("TDD By Example").when(operation).userItemName();
        library = mock(Library.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(operation, library);

        bibliotecaApp.start();

        verify(library, times(1)).checkOut("TDD By Example");
    }

    @Test
    void shouldReturnBookToLibraryIfSelectedOptionIsReturn() {
        doReturn("3", "4", "0").when(operation).userChoice();
        doReturn("TDD By Example", "TDD By Example").when(operation).userItemName();
        library = mock(Library.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(operation, library);

        bibliotecaApp.start();

        verify(library, times(1)).returnBook("TDD By Example");
    }

    @Test
    void shouldDisplayListOfMoviesIfSelectedMenuOptionIs4() {
        doReturn("2", "0").when(operation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(operation, library);

        bibliotecaApp.start();

        verify(operation).display("Harry Potter 1 | 2001 | Chris Columbus | Unrated");
    }

    @Test
    void shouldCheckOutMovieFromLibraryIfSelectedOptionsIsCheckOutMovie() {
        doReturn("5", "0").when(operation).userChoice();
        doReturn("Harry Potter 1").when(operation).userItemName();
        library = mock(Library.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(operation, library);

        bibliotecaApp.start();

        verify(library).checkOutMovie("Harry Potter 1");
    }

    @Test
    void shouldReturnMovieToLibraryIfSelectedOptionsIsReturnMovie() {
        doReturn("6", "0").when(operation).userChoice();
        doReturn("Harry Potter 1").when(operation).userItemName();
        library = mock(Library.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(operation, library);

        bibliotecaApp.start();

        verify(library).returnMovie("Harry Potter 1");
    }
}