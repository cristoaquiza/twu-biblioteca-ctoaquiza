package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

    public Library() {
        this.books = loadBooks();
    }

    public String salute() {
        return "## Welcome to The Bangalore Public Library Management System ##";
    }

    public List<Book> loadBooks() {
        List<Book> booksLoaded = new ArrayList<Book>();
        booksLoaded.add(new Book("Peter and Wendy", "J. M. Barrie", 1911));
        booksLoaded.add(new Book("Robinson Crusoe", "Daniel Defoe", 1719));
        booksLoaded.add(new Book("Gulliver's Travels", "Jonathan Swift", 1726));
        return booksLoaded;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public String printBooks() {
        String print = "";
        for(int i = 0; i < this.books.size(); i++) {
            print += (i+1) + ". " + this.books.get(i).toString() + "\n";
        }
        return print;
    }
}
