package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BookTest {
    @Test
    void shouldDisplayTheName() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Book book = new Book("TDD by Example");

        book.displayName();

        verify(out).println("TDD by Example");
    }
}