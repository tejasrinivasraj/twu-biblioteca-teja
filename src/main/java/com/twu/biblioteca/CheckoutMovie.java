package com.twu.biblioteca;

public class CheckoutMovie implements Choice {
    @Override
    public void perform(Library library, ReadWriteOperation operation) {
        String itemName = operation.userItemName();
        library.checkOutMovie(itemName);
    }
}
