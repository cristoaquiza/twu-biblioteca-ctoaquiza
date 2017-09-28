package com.twu.biblioteca;

public class Movie implements ObjectToRent {
    private String name = new String();
    private int year;
    private String director = new String();
    private int rating;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public Movie(String name, int year, String director) {
        this.name = name;
        this.year = year;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return this.getClass().toString() + "\t" + getName() + "\t" + getYear() + "\t" + getDirector() + "\t" + getRating() + "\n";
    }
}
