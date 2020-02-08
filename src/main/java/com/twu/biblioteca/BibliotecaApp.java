package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayMessage();
        bibliotecaApp.displayBooks();
    }

    private void displayMessage() {
        System.out.println(Constants.welcomeMessage);
    }

    private void displayBooks() {
        System.out.println("TDD By Example");
    }
}
