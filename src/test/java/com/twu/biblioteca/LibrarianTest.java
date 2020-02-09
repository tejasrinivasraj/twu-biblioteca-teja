package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class LibrarianTest {
    @Test
    void shouldAddCheckOutBookToCollections() {
        Librarian librarian = new Librarian();

        librarian.addToCollection(mock(Book.class));
    }
}