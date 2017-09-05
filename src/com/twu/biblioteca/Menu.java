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
        menu += "--- END MENU ---\n";
        return menu;
    }

    public boolean doTheChoice(int optionNumber) {
        boolean isCorrect = false;
        switch (optionNumber) {
            case 1:
                System.out.print(library.printBooks());
                isCorrect = true;
                break;
            default:
                isCorrect = false;
        }
        return isCorrect;
    }
}
