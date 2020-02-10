package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Menu {

    private List<String> options = new ArrayList<>(Arrays.asList(Constants.LIST_OF_BOOKS, Constants.CHECK_OUT, Constants.RETURN_BOOK, Constants.QUIT));
    private ReadWriteOperation operation;

    public Menu(ReadWriteOperation operation) {

        this.operation = operation;
    }

    void displayOptions() {
        for (String option : options) {
            operation.display(option);
        }
    }
}
