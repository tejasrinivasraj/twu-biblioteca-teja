package com.twu.biblioteca;

public class ReturnMovie implements Choice {
    @Override
    public void perform(Library library, ReadWriteOperation operation) {
        String itemName = operation.userItemName();
        library.returnMovie(itemName);
    }
}
