package com.twu.biblioteca;

public class CheckoutBook implements Choice {
    @Override
    public void perform(Library library, ReadWriteOperation operation) {
        String itemName = operation.userItemName();
        library.checkOut(itemName);
    }
}
