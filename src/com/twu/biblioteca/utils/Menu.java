package com.twu.biblioteca.utils;

import com.twu.biblioteca.library.Librarian;
import com.twu.biblioteca.library.Library;

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
        int positionOfTheObjectInTheList;
        switch (optionNumber) {
            case 1:
                System.out.print(getLibrarian().getLibrary().toString());
                break;
            case 2:
                positionOfTheObjectInTheList = getPositionOfTheObjectInTheListFromInput();
                if(positionOfTheObjectInTheList < 0) {
                    System.out.println("NOTIFICATION: Select a valid option!");
                    break;
                }
                if(!isThePositionOfObjectValidToCheckOut(positionOfTheObjectInTheList)) {
                    System.out.println("NOTIFICATION: That rental product is not available.");
                    break;
                }
                getLibrarian().checkOutObject(positionOfTheObjectInTheList);
                System.out.println("NOTIFICATION: Thank you! Enjoy the rented product.");
                break;
            case 3:
                positionOfTheObjectInTheList = getPositionOfTheObjectInTheListFromInput();
                if(positionOfTheObjectInTheList < 0) {
                    System.out.println("NOTIFICATION: Select a valid option!");
                    break;
                }
                if(!isThePositionOfObjectValidToReturn(positionOfTheObjectInTheList)) {
                    System.out.println("NOTIFICATION: That is not a valid rented product to return.");
                    break;
                }
                getLibrarian().returnObject(positionOfTheObjectInTheList);
                System.out.println("NOTIFICATION: Thank you for returning the rented product.");
                break;
        }
    }

    private int getPositionOfTheObjectInTheListFromInput() {
        Scanner read;
        String stringOfNumberInTheListOfObject;
        System.out.println("Enter the number of the object in the list: ");
        read = new Scanner(System.in);
        stringOfNumberInTheListOfObject = read.nextLine();
        try {
            return Integer.parseInt(stringOfNumberInTheListOfObject) - 1;
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    private boolean isThePositionOfObjectValidToCheckOut(int positionOfTheObjectInTheList) {
        return positionOfTheObjectInTheList >= 0 && positionOfTheObjectInTheList < librarian.getLibrary().getObjectsToRent().size() && !librarian.getLibrary().getObjectsToRent().get(positionOfTheObjectInTheList).isCheckedOut();
    }

    private boolean isThePositionOfObjectValidToReturn(int positionOfTheObjectInTheList) {
        return positionOfTheObjectInTheList >= 0 && positionOfTheObjectInTheList < librarian.getLibrary().getObjectsToRent().size() && librarian.getLibrary().getObjectsToRent().get(positionOfTheObjectInTheList).isCheckedOut();
    }

    public Librarian getLibrarian() {
        return librarian;
    }
}