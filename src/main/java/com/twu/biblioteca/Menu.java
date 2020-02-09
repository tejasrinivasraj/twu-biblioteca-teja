package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Menu {

    private List<String> options = new ArrayList<>(Arrays.asList(Constants.LIST_OF_BOOKS, Constants.CHECK_OUT, Constants.QUIT));

    void displayOptions() {
        for (String option : options) {
            System.out.println(option);
        }
    }
}
