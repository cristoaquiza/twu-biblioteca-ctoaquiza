package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        Menu menu = new Menu(library);
        Utils utils = new Utils();

        System.out.println(library.salute());

        String optionNumber = "";
        do {
            System.out.println(menu.printMenu());
            System.out.println("Enter the option number to do: ");
            Scanner read = new Scanner(System.in);
            optionNumber = read.nextLine();

            if (utils.parseInputToInt(optionNumber) >= 0 && menu.doTheChoice(utils.parseInputToInt(optionNumber))) { }
            else { System.out.println("Select a valid option!"); }
        } while (utils.parseInputToInt(optionNumber) != 0);
    }
}
