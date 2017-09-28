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
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\t" +
                getTitle() + "\t" +
                getAuthor() + "\t" +
                getYear() + "\n";
    }

    @Override
    public void setObjectAsCheckedOut() {

    }

    @Override
    public boolean isCheckedOut() {
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
