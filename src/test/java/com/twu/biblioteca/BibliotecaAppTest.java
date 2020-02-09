package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BibliotecaAppTest {
    @Test
    void shouldDisplayWelcomeMessageUponStart() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        BibliotecaApp.main(new String[]{});

        verify(out).println(Constants.welcomeMessage);
    }

    @Test
    void shouldDisplayOneBooksIfThereIsOnlyOneBook() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        BibliotecaApp.main(new String[]{});

        verify(out).println("TDD By Example | Kent Beck | 2000");
    }

    @Test
    void shouldDisplayListOfAllBooksIfThereAreMultipleBooks() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        BibliotecaApp.main(new String[]{});

        verify(out).println("TDD By Example | Kent Beck | 2000");
        verify(out).println("Clean Code | Robert C. Martin | 2008");
    }

    @Test
    void shouldDisplayListOfMenuOptions() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        BibliotecaApp.main(new String[]{});

        verify(out).println(Constants.LIST_OF_BOOKS);
    }
}