package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BibliotecaAppTest {
    @Test
    void shouldDisplayWelcomeMessageUponStart() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        BibliotecaApp.main(new String[]{});

        verify(out).println(Constants.welcomeMessage);
    }

    @Test
    void shouldDisplayOneBooksIfThereIsOnlyOneBook() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        BibliotecaApp.main(new String[]{});

        verify(out).println("TDD By Example");
    }
}