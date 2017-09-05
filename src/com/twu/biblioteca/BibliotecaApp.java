package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        System.out.println(library.salute());
        library.loadBooks();
        System.out.println(library.getMenu());
    }
}
