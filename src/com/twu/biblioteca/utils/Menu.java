package com.twu.biblioteca.utils;

import com.twu.biblioteca.library.Librarian;

import java.util.Scanner;

public class Menu {

    private Librarian librarian;

    public Menu(Librarian librarian) {
        this.librarian = librarian;
    }

    public String getMenuToString() {
        return "\n\t---- MENU ----\n" +
                "[1] List Objects to rent\t" +
                "[2] Checkout Object\t" +
                "[3] Return Object\t" +
                "[4] View User Information\t" +
                "[0] Quit\n" +
                "\t--- END MENU ---\n";
    }

    public void doTheChoice(int optionNumber, String libraryNumber) {
        int positionOfTheObjectInTheList;
        switch (optionNumber) {
            case 1:
                System.out.print(getLibrarian().getObjectCatalog().toString());
                break;
            case 2:
                positionOfTheObjectInTheList = getPositionOfTheObjectInTheListFromInput();
                if(isNotYourInputANumber(positionOfTheObjectInTheList)) {
                    System.out.println("NOTIFICATION: Select a valid option!");
                    break;
                }
                if(!isThePositionOfObjectValidToCheckOut(positionOfTheObjectInTheList)) {
                    System.out.println("NOTIFICATION: That rental product is not available.");
                    break;
                }
                getLibrarian().checkOutObject(positionOfTheObjectInTheList, libraryNumber);
                System.out.println("NOTIFICATION: Thank you! Enjoy the rented product.");
                break;
            case 3:
                positionOfTheObjectInTheList = getPositionOfTheObjectInTheListFromInput();
                if(isNotYourInputANumber(positionOfTheObjectInTheList)) {
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
            case 4:
                System.out.println(getLibrarian().findUserInCatalogByLibrarianNumber(libraryNumber).toString());
                break;
        }
    }

    private boolean isNotYourInputANumber(int positionOfTheObjectInTheList) {
        return positionOfTheObjectInTheList < 0;
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
        return positionOfTheObjectInTheList >= 0 && positionOfTheObjectInTheList < librarian.getObjectCatalog().getObjectsToRent().size() && !librarian.getObjectCatalog().getObjectsToRent().get(positionOfTheObjectInTheList).isCheckedOut();
    }

    private boolean isThePositionOfObjectValidToReturn(int positionOfTheObjectInTheList) {
        return positionOfTheObjectInTheList >= 0 && positionOfTheObjectInTheList < librarian.getObjectCatalog().getObjectsToRent().size() && librarian.getObjectCatalog().getObjectsToRent().get(positionOfTheObjectInTheList).isCheckedOut();
    }

    public Librarian getLibrarian() {
        return librarian;
    }
}
