package com.twu.biblioteca;

public enum Rating {
    UNRATED("Unrated");

    private String rating;

    Rating(String rating) {

        this.rating = rating;
    }

    public String display() {
        return rating;
    }
}
