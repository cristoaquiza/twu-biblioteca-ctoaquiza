package com.twu.biblioteca;

public class Movie implements ObjectToRent {
    public String title;

    public Movie(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "title : " + this.title + "\n";
    }
}
