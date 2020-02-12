package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

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

    @Test
    void shouldDisplayDisplayListOfMoviesOptionInMenu() {
        Menu menu = new Menu(operation);

        menu.displayOptions();

        verify(operation).display(Constants.LIST_OF_MOVIES);
    }

    @Test
    void shouldDisplayCheckOutMovieOptionInMenu() {
        Menu menu = new Menu(operation);

        menu.displayOptions();

        verify(operation).display(Constants.CHECK_OUT_MOVIE);
    }

    @Test
    void shouldDisplayReturnMovieOptionInMenu() {
        Menu menu = new Menu(operation);

        menu.displayOptions();

        verify(operation).display(Constants.RETURN_MOVIE);
    }

    @Test
    void shouldNotDisplayCheckOutOptionInDefaultMenu() {
        Menu menu = new Menu(operation);

        menu.defaultOptions();

        verify(operation).display(Constants.LIST_OF_BOOKS);
        verify(operation).display(Constants.LIST_OF_MOVIES);
        verify(operation).display(Constants.QUIT);
        verify(operation, times(0)).display(Constants.CHECK_OUT);
    }

    @Test
    void shouldDisplayLoginOptionInDefaultMenu() {
        Menu menu = new Menu(operation);

        menu.defaultOptions();

        verify(operation).display(Constants.LOGIN);
    }
}