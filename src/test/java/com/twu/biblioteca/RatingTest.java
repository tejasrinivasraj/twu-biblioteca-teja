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

    @Test
    void shouldReturn2IfRatingIsTwo() {
        Rating rating = Rating.TWO;

        String display = rating.display();

        assertEquals("2", display);
    }

    @Test
    void shouldReturn3IfRatingIsThree() {
        Rating rating = Rating.THREE;

        String display = rating.display();

        assertEquals("3", display);
    }

    @Test
    void shouldReturn4IfRatingIsFour() {
        Rating rating = Rating.FOUR;

        String display = rating.display();

        assertEquals("4", display);
    }
}