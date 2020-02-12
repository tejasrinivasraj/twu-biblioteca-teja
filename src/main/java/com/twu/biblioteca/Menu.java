package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Menu {

    private List<String> options = new ArrayList<>(Arrays.asList(Constants.LIST_OF_BOOKS, Constants.CHECK_OUT, Constants.RETURN_BOOK, Constants.LIST_OF_MOVIES, Constants.CHECK_OUT_MOVIE, Constants.RETURN_MOVIE, Constants.QUIT));
    private ReadWriteOperation operation;

    public Menu(ReadWriteOperation operation) {

        this.operation = operation;
    }

    void displayOptions() {
        for (String option : options) {
            operation.display(option);
        }
    }

    void defaultOptions() {
        operation.display(Constants.LIST_OF_BOOKS);
        operation.display(Constants.LIST_OF_MOVIES);
        operation.display(Constants.LOGIN);
        operation.display(Constants.QUIT);
    }
}
