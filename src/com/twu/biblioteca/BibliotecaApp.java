package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        Menu menu = new Menu(library);

        System.out.println(library.salute());

        System.out.println(menu.printMenu());

        System.out.println("Enter the option number to do: ");
        Scanner read = new Scanner(System.in);
        String optionNumber = read.nextLine();

        if(menu.parseInputToInt(optionNumber) >= 0 && menu.doTheChoice(menu.parseInputToInt(optionNumber))) {}
        else {
            System.out.println("Select a valid option!");
        }
    }
}
