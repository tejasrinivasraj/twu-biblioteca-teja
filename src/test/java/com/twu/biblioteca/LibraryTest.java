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
        Library library = new Library(new ArrayList<>(Collections.singletonList(book)));

        library.displayBooks();

        verify(book, times(1)).displayInformation();
    }
}