package com.twu.biblioteca;

import java.util.Scanner;

class ReadWriteOperation {
    private Scanner scan = new Scanner(System.in);

    String userChoice() {
        return scan.nextLine();
    }

    String bookName() {
        return scan.nextLine();
    }

    void display(String message) {
        System.out.println(message);
    }
}
