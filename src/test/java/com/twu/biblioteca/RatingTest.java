package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatingTest {
    @Test
    void shouldReturnUnratedIfRatingIsUnrated() {
        Rating rating = Rating.UNRATED;

        String display = rating.display();

        assertEquals("Unrated", display);
    }

    @Test
    void shouldReturn1IfRatingIsOne() {
        Rating rating = Rating.ONE;

        String display = rating.display();

        assertEquals("1", display);
    }
}