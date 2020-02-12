package com.twu.biblioteca;

public class ListMovies implements Choice{
    @Override
    public void perform(Library library, ReadWriteOperation operation) {
        library.displayMovies();
    }
}
