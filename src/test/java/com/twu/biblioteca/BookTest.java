package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldReturnInformation() {
        Book book = new Book("TDD by Example", "Kent Beck", "1980");

        String actualInformation = book.returnInformation();

        assertEquals("TDD by Example | Kent Beck | 1980", actualInformation);
    }

    @Test
    void shouldReturnTrueIfBookNameIsSame() {
        Book book = new Book("TDD by Example", "Kent Beck", "1980");

        assertTrue(book.isName("TDD by Example"));
    }

    @Test
    void shouldReturnFalseIfBookNameIsNotSame() {
        Book book = new Book("TDD by Example", "Kent Beck", "1980");

        assertFalse(book.isName("Clean Code"));
    }
}