package com.twu.biblioteca;

import com.twu.biblioteca.Exception.QuitMenuException;

public class Quit implements Choice {
    @Override
    public void perform(Library library, ReadWriteOperation operation) throws QuitMenuException {
        throw new QuitMenuException();
    }
}
