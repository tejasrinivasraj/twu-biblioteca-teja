package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.Mockito.*;

class LibraryTest {
    @Test
    void shouldDisplayInformationOfTheBooks() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Book book = mock(Book.class);
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), mock(Librarian.class));

        library.displayBooks();

        verify(book, times(1)).displayInformation();
    }

    @Test
    void shouldRequestLibrarianToAddToCollection() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Book book = mock(Book.class);
        doReturn(true).when(book).isName("TDD By Example");
        Librarian librarian = mock(Librarian.class);
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)), librarian);

        library.checkOut("TDD By Example");

        verify(librarian, times(1)).addToCollection(book);
    }
}