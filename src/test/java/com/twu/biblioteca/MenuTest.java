package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MenuTest {

    @Test
    void shouldDisplayOneOptionInMenuIfThereIsOnlyOne() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Menu menu = new Menu();

        menu.displayOptions();

        verify(out).println(Constants.LIST_OF_BOOKS);
    }

    @Test
    void shouldDisplayMultipleOptionInMenuIfThereAreMoreThanOne() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Menu menu = new Menu();

        menu.displayOptions();

        verify(out).println(Constants.LIST_OF_BOOKS);
        verify(out).println(Constants.QUIT);
    }

    @Test
    void shouldDisplayCheckOutOptionInMenu() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Menu menu = new Menu();

        menu.displayOptions();

        verify(out).println(Constants.LIST_OF_BOOKS);
        verify(out).println(Constants.QUIT);
        verify(out).println(Constants.CHECK_OUT);
    }

    @Test
    void shouldDisplayReturnOptionInMenu() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Menu menu = new Menu();

        menu.displayOptions();

        verify(out).println(Constants.LIST_OF_BOOKS);
        verify(out).println(Constants.QUIT);
        verify(out).println(Constants.CHECK_OUT);
        verify(out).println(Constants.RETURN_BOOK);
    }
}