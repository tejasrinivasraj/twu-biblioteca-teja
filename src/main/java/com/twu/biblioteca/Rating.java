package com.twu.biblioteca;

public enum Rating {
    UNRATED("Unrated"), ONE("1"), TWO("2"), THREE("3");

    private String rating;

    Rating(String rating) {

        this.rating = rating;
    }

    public String display() {
        return rating;
    }
}
