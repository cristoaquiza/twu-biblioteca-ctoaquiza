package com.twu.biblioteca;

public class Book implements ObjectToRent{
    private String title;
    private String author;
    private int year;
    private boolean checkedOut;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.checkedOut = false;
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
        if (areAllOfFieldsUnEquals(otherBook)) {
            return false;
        }
        return true;
    }

    private boolean areAllOfFieldsUnEquals(Book otherBook) {
        return !otherBook.getAuthor().equals(this.getAuthor()) || !otherBook.getTitle().equals(this.getTitle()) || otherBook.getYear() != this.getYear();
    }

    @Override
    public String toString() {
        String print = "";
        print += "Title: " + this.title + "\t";
        print += "Author: " + this.author + "\t";
        print += "Year published: " + this.year;
        return print;
    }

    public boolean getCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
