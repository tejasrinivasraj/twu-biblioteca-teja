package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BibliotecaAppTest {
    @Test
    void shouldDisplayWelcomeMessageUponStart() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        BibliotecaApp.main(new String[]{});

        verify(out).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}