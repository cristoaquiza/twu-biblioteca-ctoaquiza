package com.twu.biblioteca;

public class Movie implements ObjectToRent {
    public String name = new String();
    public int year;
    public String director = new String();
    public int rating;

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

    @Override
    public String toString() {
        return this.getClass().toString() + "\t" + this.name + "\t" + this.year + "\t" + this.director + "\t" + this.rating + "\n";
    }
}
