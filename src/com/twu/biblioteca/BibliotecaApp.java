package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        System.out.println(library.salute());
        library.loadBooks();
        System.out.println(library.getMenu());
        System.out.println("Enter the option number to do: ");
        Scanner read = new Scanner(System.in);
        String optionMenu = read.nextLine();
    }
}
