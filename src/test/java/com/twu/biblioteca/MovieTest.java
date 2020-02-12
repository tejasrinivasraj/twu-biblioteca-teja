package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    @Test
    void shouldReturnInformation() {
        Movie movie = new Movie("Harry Potter 1", "2001", "Chris Columbus", Rating.UNRATED);

        String actualInformation = movie.returnInformation();

        assertEquals("Harry Potter 1 | 2001 | Chris Columbus | Unrated", actualInformation);
    }

    @Test
    void shouldReturnTrueIfMovieNameIsSame() {
        Movie movie = new Movie("Harry Potter 1", "2001", "Chris Columbus", Rating.UNRATED);

        assertTrue(movie.isName("Harry Potter 1"));
    }

    @Test
    void shouldReturnFalseIfMovieNameIsDifferent() {
        Movie movie = new Movie("Harry Potter 1", "2001", "Chris Columbus", Rating.UNRATED);

        assertFalse(movie.isName("Harry Potter 2"));
    }
}
