package com.twu.biblioteca;

public class ListBooks implements Choice {
    @Override
    public void perform(Library library, ReadWriteOperation operation) {
        library.displayBooks();
    }
}
