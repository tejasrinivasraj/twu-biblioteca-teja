package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.Mockito.*;

class LibraryTest {

    private ReadWriteOperation writeOperation;

    @BeforeEach
    void setup() {
        writeOperation = mock(ReadWriteOperation.class);
    }

    @Test
    void shouldDisplayInformationOfTheBooks() {
        Book book = mock(Book.class);
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), new ArrayList<>(), mock(Librarian.class), writeOperation, new ArrayList<>());

        library.displayBooks();

        verify(book, times(1)).returnInformation();
    }

    @Test
    void shouldRequestLibrarianToAddToCollection() {
        Book book = mock(Book.class);
        doReturn(true).when(book).isName("TDD By Example");
        Librarian librarian = mock(Librarian.class);
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), new ArrayList<>(), librarian, writeOperation, new ArrayList<>());

        library.checkOut("TDD By Example");

        verify(librarian, times(1)).addToCollection(book);
    }

    @Test
    void shouldNotDisplayBookInListIfTheBookIsCheckOut() {
        Book book = mock(Book.class);
        doReturn(true).when(book).isName("TDD By Example");
        Librarian librarian = mock(Librarian.class);
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), new ArrayList<>(), librarian, writeOperation, new ArrayList<>());

        library.checkOut("TDD By Example");
        library.displayBooks();

        verify(book, times(0)).returnInformation();
    }

    @Test
    void shouldNotifyOnSuccessfulCheckout() {
        Book book = mock(Book.class);
        doReturn(true).when(book).isName("TDD By Example");
        Librarian librarian = mock(Librarian.class);
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), new ArrayList<>(), librarian, writeOperation, new ArrayList<>());

        library.checkOut("TDD By Example");
        library.displayBooks();

        verify(writeOperation).display(Constants.CHECKOUT_SUCCESS);
    }

    @Test
    void shouldNotifyOnUnSuccessfulCheckout() {
        Book book = mock(Book.class);
        doReturn(true).when(book).isName("TDD By Example");
        Librarian librarian = mock(Librarian.class);
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), new ArrayList<>(), librarian, writeOperation, new ArrayList<>());

        library.checkOut("TDD");

        verify(writeOperation).display(Constants.CHECKOUT_FAILED);
    }

    @Test
    void shouldReturnBookFromLibrarianCollectionIfReturnBook() {
        Book book = mock(Book.class);
        doReturn(true).when(book).isName("TDD By Example");
        Librarian librarian = mock(Librarian.class);
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), new ArrayList<>(), librarian, writeOperation, new ArrayList<>());
        library.checkOut("TDD By Example");

        library.returnBook("TDD By Example");

        verify(librarian).returnBook("TDD By Example");
    }

    @Test
    void shouldDisplayBookInListIfReturnBook() {
        Book book = new Book("TDD By Example","Kent Beck", "2000");
        Librarian librarian = new Librarian();
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), new ArrayList<>(), librarian, writeOperation, new ArrayList<>());
        library.checkOut("TDD By Example");

        library.returnBook("TDD By Example");
        library.displayBooks();

        verify(writeOperation).display("TDD By Example | Kent Beck | 2000");
    }

    @Test
    void shouldNotifyOnSuccessfulReturn() {
        Book book = new Book("TDD By Example","Kent Beck", "2000");
        Librarian librarian = new Librarian();
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), new ArrayList<>(), librarian, writeOperation, new ArrayList<>());
        library.checkOut("TDD By Example");

        library.returnBook("TDD By Example");

        verify(writeOperation).display(Constants.RETURN_SUCCESS);
    }

    @Test
    void shouldNotifyOnUnSuccessfulReturn() {
        Book book = new Book("TDD By Example","Kent Beck", "2000");
        Librarian librarian = new Librarian();
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), new ArrayList<>(), librarian, writeOperation, new ArrayList<>());
        library.checkOut("TDD By Example");

        library.returnBook("TDD without Example");

        verify(writeOperation).display(Constants.RETURN_FAILED);
    }

    @Test
    void shouldDisplayInformationOfTheMovies() {
        Movie movie = mock(Movie.class);
        Library library = new Library(new ArrayList<>(Collections.singletonList(mock(Book.class))), new ArrayList<>(Collections.singletonList(movie)), mock(Librarian.class), writeOperation, new ArrayList<>());

        library.displayMovies();

        verify(writeOperation, times(1)).display(movie.returnInformation());
    }

    @Test
    void shouldNotDisplayMovieInListIfTheMovieIsCheckOut() {
        Movie movie = new Movie("Harry Potter 1", "2001", "Chris Columbus", Rating.UNRATED);
        Library library = new Library(new ArrayList<>(Collections.singletonList(mock(Book.class))), new ArrayList<>(Collections.singletonList(movie)), mock(Librarian.class), writeOperation, new ArrayList<>());


        library.checkOutMovie("Harry Potter 1");
        library.displayMovies();

        verify(writeOperation, times(0)).display(movie.returnInformation());
    }

    @Test
    void shouldDisplayMovieInListIfReturnMovie() {
        Movie movie = new Movie("Harry Potter 1", "2001", "Chris Columbus", Rating.UNRATED);
        Library library = new Library(new ArrayList<>(Collections.singletonList(mock(Book.class))), new ArrayList<>(Collections.singletonList(movie)), mock(Librarian.class), writeOperation, new ArrayList<>());
        library.checkOutMovie("Harry Potter 1");

        library.returnMovie("Harry Potter 1");
        library.displayMovies();

        verify(writeOperation, times(1)).display(movie.returnInformation());
    }
}