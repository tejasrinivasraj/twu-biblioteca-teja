package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticatorTest {
    @Test
    void shouldReturnTrueIfUserNameAndPasswordMatches() {
        Authenticator authenticator = new Authenticator(new HashMap<>(Map.of("014-0199","authorized")));

        assertTrue(authenticator.isAuthorized("014-0199", "authorized"));
    }

    @Test
    void shouldReturnFalseIfUserNameAndPasswordWontMatches() {
        Authenticator authenticator = new Authenticator(new HashMap<>(Map.of("014-0199","authorized")));

        assertFalse(authenticator.isAuthorized("014-0190", "authorized"));
    }
}