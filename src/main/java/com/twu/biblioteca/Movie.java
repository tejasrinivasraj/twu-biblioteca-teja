package com.twu.biblioteca;

public class Movie {
    private final String name;
    private final String year;
    private final String director;
    private final Rating rating;

    public Movie(String name, String year, String director, Rating rating) {

        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String returnInformation() {
        return name + " | " + year + " | " + director + " | " + rating.display();
    }

    public boolean isName(String name) {
        return name.equals(this.name);
    }
}