package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayMessage();
    }

    private void displayMessage() {
        System.out.println(Constants.welcomeMessage);
    }
}
