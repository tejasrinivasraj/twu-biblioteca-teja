package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.Mockito.*;

class LibraryTest {

    private ReadWriteOperation writeOperation = new ReadWriteOperation();
    @Test
    void shouldDisplayInformationOfTheBooks() {
        Book book = mock(Book.class);
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), mock(Librarian.class), writeOperation);

        library.displayBooks();

        verify(book, times(1)).returnInformation();
    }

    @Test
    void shouldRequestLibrarianToAddToCollection() {
        Book book = mock(Book.class);
        doReturn(true).when(book).isName("TDD By Example");
        Librarian librarian = mock(Librarian.class);
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), librarian, writeOperation);

        library.checkOut("TDD By Example");

        verify(librarian, times(1)).addToCollection(book);
    }

    @Test
    void shouldNotDisplayBookInListIfTheBookIsCheckOut() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Book book = mock(Book.class);
        doReturn(true).when(book).isName("TDD By Example");
        Librarian librarian = mock(Librarian.class);
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), librarian, writeOperation);

        library.checkOut("TDD By Example");
        library.displayBooks();

        verify(book, times(0)).returnInformation();
    }

    @Test
    void shouldNotifyOnSuccessfulCheckout() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Book book = mock(Book.class);
        doReturn(true).when(book).isName("TDD By Example");
        Librarian librarian = mock(Librarian.class);
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), librarian, writeOperation);

        library.checkOut("TDD By Example");
        library.displayBooks();

        verify(out).println(Constants.CHECKOUT_SUCCESS);
    }

    @Test
    void shouldNotifyOnUnSuccessfulCheckout() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Book book = mock(Book.class);
        doReturn(true).when(book).isName("TDD By Example");
        Librarian librarian = mock(Librarian.class);
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), librarian, writeOperation);

        library.checkOut("TDD");

        verify(out).println(Constants.CHECKOUT_FAILED);
    }

    @Test
    void shouldReturnBookFromLibrarianCollectionIfReturnBook() {
        Book book = mock(Book.class);
        doReturn(true).when(book).isName("TDD By Example");
        Librarian librarian = mock(Librarian.class);
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), librarian, writeOperation);
        library.checkOut("TDD By Example");

        library.returnBook("TDD By Example");

        verify(librarian).returnBook("TDD By Example");
    }

    @Test
    void shouldDisplayBookInListIfReturnBook() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Book book = new Book("TDD By Example","Kent Beck", "2000");
        Librarian librarian = new Librarian();
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), librarian, writeOperation);
        library.checkOut("TDD By Example");

        library.returnBook("TDD By Example");
        library.displayBooks();

        verify(out).println("TDD By Example | Kent Beck | 2000");
    }

    @Test
    void shouldNotifyOnSuccessfulReturn() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Book book = new Book("TDD By Example","Kent Beck", "2000");
        Librarian librarian = new Librarian();
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), librarian, writeOperation);
        library.checkOut("TDD By Example");

        library.returnBook("TDD By Example");

        verify(out).println(Constants.RETURN_SUCCESS);
    }

    @Test
    void shouldNotifyOnUnSuccessfulReturn() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Book book = new Book("TDD By Example","Kent Beck", "2000");
        Librarian librarian = new Librarian();
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), librarian, writeOperation);
        library.checkOut("TDD By Example");

        library.returnBook("TDD without Example");

        verify(out).println(Constants.RETURN_FAILED);
    }
}