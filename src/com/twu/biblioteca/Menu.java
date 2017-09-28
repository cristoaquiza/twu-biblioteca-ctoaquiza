package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {

    private Library library;
    private Librarian librarian;

    public Menu(Library library) {
        this.library = library;
    }

    public Menu(Librarian librarian) {
        this.librarian = librarian;
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
                System.out.print(getLibrarian().getLibrary().toString());
                break;
            case 2:
                System.out.println("Enter the book number to checkout: ");
                Scanner read = new Scanner(System.in);
                String stringOfNumberInTheListOfObject = read.nextLine();
                int numberInTheListOfObject = Integer.parseInt(stringOfNumberInTheListOfObject);
                librarian.checkOutObject(numberInTheListOfObject);
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

    public Librarian getLibrarian() {
        return librarian;
    }
}
