package com.twu.biblioteca;

public class ReturnBook implements Choice {
    @Override
    public void perform(Library library, ReadWriteOperation operation) {
        String itemName = operation.userItemName();
        library.returnBook(itemName);
    }
}
