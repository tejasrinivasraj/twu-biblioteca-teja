package com.twu.biblioteca;

import com.ginsberg.junit.exit.ExpectSystemExitWithStatus;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

class BibliotecaAppTest {
    @Test
    void shouldDisplayWelcomeMessageUponStart() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        ReadOperation readOperation = mock(ReadOperation.class);
        doReturn("1").when(readOperation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(readOperation);

        bibliotecaApp.start();

        verify(out).println(Constants.WELCOME_MESSAGE);
    }

    @Test
    void shouldDisplayOneBooksIfThereIsOnlyOneBook() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        ReadOperation readOperation = mock(ReadOperation.class);
        doReturn("1").when(readOperation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(readOperation);

        bibliotecaApp.start();

        verify(out).println("TDD By Example | Kent Beck | 2000");
    }

    @Test
    void shouldDisplayListOfAllBooksIfThereAreMultipleBooks() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        ReadOperation readOperation = mock(ReadOperation.class);
        doReturn("1").when(readOperation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(readOperation);

        bibliotecaApp.start();

        verify(out).println("TDD By Example | Kent Beck | 2000");
        verify(out).println("Clean Code | Robert C. Martin | 2008");
    }

    @Test
    void shouldDisplayListOfMenuOptions() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        ReadOperation readOperation = mock(ReadOperation.class);
        doReturn("1").when(readOperation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(readOperation);

        bibliotecaApp.start();

        verify(out).println(Constants.LIST_OF_BOOKS);
    }

    @Test
    void shouldDisplayListOfBooksIfSelectedMenuOptionIs1() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        ReadOperation readOperation = mock(ReadOperation.class);
        doReturn("1").when(readOperation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(readOperation);

        bibliotecaApp.start();

        verify(out).println("TDD By Example | Kent Beck | 2000");
    }

    @Test
    void shouldDisplayInvalidMessageIfSelectedMenuOptionIsNotValid() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        ReadOperation readOperation = mock(ReadOperation.class);
        doReturn("10").when(readOperation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(readOperation);

        bibliotecaApp.start();

        verify(out).println(Constants.INVALID_MESSAGE);
    }

    @Test
    @ExpectSystemExitWithStatus(0)
    void shouldCloseIfSelectedMenuOptionIsQuit() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        ReadOperation readOperation = mock(ReadOperation.class);
        doReturn("0").when(readOperation).userChoice();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(readOperation);

        bibliotecaApp.start();
    }
}