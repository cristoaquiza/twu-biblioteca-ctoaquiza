package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book otherBook = (Book) obj;
        if (!otherBook.author.equals(this.author) || !otherBook.title.equals(this.title) || otherBook.year != this.year) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String print = "";
        print += "Title: " + this.title + "\t";
        print += "Author: " + this.author + "\t";
        print += "Year published: " + this.year + "\n";
        return print;
    }
}
