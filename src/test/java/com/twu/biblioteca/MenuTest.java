package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MenuTest {

    private ReadWriteOperation operation;

    @BeforeEach
    void setup() {
        operation = mock(ReadWriteOperation.class);
    }

    @Test
    void shouldDisplayOneOptionInMenuIfThereIsOnlyOne() {
        Menu menu = new Menu(operation);

        menu.displayOptions();

        verify(operation).display(Constants.LIST_OF_BOOKS);
    }

    @Test
    void shouldDisplayMultipleOptionInMenuIfThereAreMoreThanOne() {
        Menu menu = new Menu(operation);

        menu.displayOptions();

        verify(operation).display(Constants.QUIT);
    }

    @Test
    void shouldDisplayCheckOutOptionInMenu() {
        Menu menu = new Menu(operation);

        menu.displayOptions();

        verify(operation).display(Constants.CHECK_OUT);
    }

    @Test
    void shouldDisplayReturnOptionInMenu() {
        Menu menu = new Menu(operation);

        menu.displayOptions();

        verify(operation).display(Constants.RETURN_BOOK);
    }
}