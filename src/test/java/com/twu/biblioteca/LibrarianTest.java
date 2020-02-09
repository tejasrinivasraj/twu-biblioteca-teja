package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class LibrarianTest {
    @Test
    void shouldAddCheckOutBookToCollections() {
        Librarian librarian = new Librarian();

        librarian.addToCollection(mock(Book.class));
    }

    @Test
    void shouldReturnBookIfNameIsSameAsBooksNameInCollection() {
        Librarian librarian = new Librarian();
        Book book = new Book("TDD By Example","Kent Beck", "2000");
        librarian.addToCollection(book);

        Book actualBook = librarian.returnBook("TDD By Example");

        Assertions.assertEquals(new Book("TDD By Example","Kent Beck", "2000"), actualBook);
    }
}