package com.twu.biblioteca.library.objectsToRent;

import com.twu.biblioteca.library.ObjectToRent;

public class Movie implements ObjectToRent {
    private String name = new String();
    private int year;
    private String director = new String();
    private double rating;
    private boolean checkedOut;

    public Movie(String name, int year, String director, double rating) {
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
        return this.getClass().getSimpleName() + "\t" +
                getName() + "\t" +
                getYear() + "\t" +
                getDirector() + "\t" +
                getRating() + "\n";
    }

    @Override
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    @Override
    public boolean isCheckedOut() {
        return checkedOut;
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

    public double getRating() {
        return rating;
    }
}
