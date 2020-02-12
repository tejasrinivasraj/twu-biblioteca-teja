package com.twu.biblioteca;

public class Invalid implements Choice{
    @Override
    public void perform(Library library, ReadWriteOperation operation) {
        operation.display(Constants.INVALID_MESSAGE);
    }
}
