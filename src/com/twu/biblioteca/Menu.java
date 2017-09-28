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
        menu += "3. Return Book\n";
        menu += "0. Quit\n";
        menu += "--- END MENU ---\n";
        return menu;
    }

    public void doTheChoice(int optionNumber) {
        switch (optionNumber) {
            case 1:
                System.out.print(library.toString());
                break;
            case 2:
                if(library.checkoutBook()) {
                    System.out.println("Thank you! Enjoy the book");
                } else {
                    System.out.println("That book is not available.");
                }
                break;
            case 3:
                if(library.returnBook()) {
                    System.out.println("Thank you for returning the book.");
                } else {
                    System.out.println("That is not a valid book to return.");
                }
                break;
        }
    }
}
