package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<String> books;

    public String salute() {
        return "Welcome to The Bangalore Public Library Management System";
    }

    public List<Object> loadBooks() {
        List<Object> booksLoaded = new ArrayList<Object>();
        booksLoaded.add(new Object());
        return booksLoaded;
    }

}
