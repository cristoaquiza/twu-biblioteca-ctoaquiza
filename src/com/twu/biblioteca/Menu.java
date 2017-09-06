package com.twu.biblioteca;

public class Menu {

    private Library library;

    public Menu(Library library) {
        this.library = library;
    }

    public String printMenu() {
        String menu = "";
        menu += "---- MENU ----\n";
        menu += "1. List Books\n";
        menu += "2. Checkout Book\n";
        menu += "0. Quit\n";
        menu += "--- END MENU ---\n";
        return menu;
    }

    public boolean doTheChoice(int optionNumber) {
        switch (optionNumber) {
            case 1:
                System.out.print(library.printBooks());
                return true;
            case 0:
                return true;
            case 2:
                library.checkoutBook();
                return true;
            default:
                return false;
        }
    }

    public int parseInputToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return -1;
        }
    }
}
