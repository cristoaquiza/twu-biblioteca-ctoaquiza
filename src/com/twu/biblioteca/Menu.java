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
        menu += "\n\t---- MENU ----\n";
        menu += "[1] List Objects to rent\t";
        menu += "[2] Checkout Object\t";
        menu += "[3] Return Object\t";
        menu += "[0] Quit\n";
        menu += "\t--- END MENU ---\n";
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
                int positionOfTheObjectInTheList = Integer.parseInt(stringOfNumberInTheListOfObject);
                if(!isThePositionOfObjectValidToCheckOut(positionOfTheObjectInTheList)) {
                    System.out.println("NOTIFICATION: That book is not available.");
                    break;
                }
                librarian.checkOutObject(positionOfTheObjectInTheList);
                System.out.println("NOTIFICATION: Thank you! Enjoy the book.");
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

    private boolean isThePositionOfObjectValidToCheckOut(int positionOfTheObjectInTheList) {
        return positionOfTheObjectInTheList >= 0 && positionOfTheObjectInTheList < librarian.getLibrary().getObjectsToRent().size() && !librarian.getLibrary().getObjectsToRent().get(positionOfTheObjectInTheList).isCheckedOut();
    }

    public Librarian getLibrarian() {
        return librarian;
    }
}
