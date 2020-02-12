package com.twu.biblioteca;

import com.twu.biblioteca.Exception.QuitMenuException;

public interface Choice {
    void perform(Library library, ReadWriteOperation operation) throws QuitMenuException;
}
