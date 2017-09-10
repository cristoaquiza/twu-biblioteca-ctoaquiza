package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private static Library library = new Library();
    private static Menu menu = new Menu(library);
    private static Utils utils = new Utils();

    public static void main(String[] args) {
        System.out.println(library.salute());

        String optionNumber = "";
        do {
            System.out.println(menu.printMenu());
            System.out.println("Enter the option number to do: ");
            Scanner read = new Scanner(System.in);
            optionNumber = read.nextLine();
            if (isTheOptionEnteredOnTheRangeOfMenuOptions(optionNumber)) {
                menu.doTheChoice(utils.parseInputToInt(optionNumber));
            }
            else {
                System.out.println("Select a valid option!");
            }
        } while (isTheOptionEnteredNonZero(optionNumber));
    }

    private static boolean isTheOptionEnteredNonZero(String optionNumber) {
        return utils.parseInputToInt(optionNumber) != 0;
    }

    private static boolean isTheOptionEnteredOnTheRangeOfMenuOptions(String optionNumber) {
        return utils.parseInputToInt(optionNumber) >= 0 && utils.parseInputToInt(optionNumber) <= 3;
    }
}
