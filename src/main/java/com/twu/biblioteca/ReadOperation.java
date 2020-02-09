package com.twu.biblioteca;

import java.util.Scanner;

class ReadOperation {
    private Scanner scan = new Scanner(System.in);

    String userChoice() {
        return scan.next();
    }
}
