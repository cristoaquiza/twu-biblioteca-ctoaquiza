package com.twu.biblioteca.library;

import com.twu.biblioteca.utils.Utils;

public class Menu {

    private Librarian librarian;
    private final int NUMBER_OF_LIST_OPTION = 1;
    private final int NUMBER_OF_CHECK_OUT_OPTION = 2;
    private final int NUMBER_OF_RETURN_OPTION = 3;
    private final int NUMBER_OF_VIEW_USER_INFORMATION_OPTION = 4;
    public static final int NUMBER_OF_EXIT_OPTION = 0;

    public Menu(Librarian librarian) {
        this.librarian = librarian;
    }

    public Librarian getLibrarian() {
        return librarian;
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

    public void performTheChosen(int optionNumber, String libraryNumber) {
        int positionOfTheObjectInTheList = -1;
        if(optionNumber == NUMBER_OF_CHECK_OUT_OPTION || optionNumber == NUMBER_OF_RETURN_OPTION) {
            positionOfTheObjectInTheList = Utils.convertFromStringToInt(Utils.getAKeyboardInput("Enter the number of the object in the list: "));
            if (!isValidYourPosition(positionOfTheObjectInTheList)) {
                Utils.printNotification("Select a valid option!");
                return;
            }
        }
        switch (optionNumber) {
            case NUMBER_OF_LIST_OPTION:
                Utils.print(librarian.getObjectCatalog().toString());
                break;
            case NUMBER_OF_CHECK_OUT_OPTION:
                if(!isThePositionOfObjectValidToCheckOut(positionOfTheObjectInTheList)) {
                    Utils.printNotification("That rental product is not available.");
                    break;
                }
                librarian.checkOutObject(positionOfTheObjectInTheList, libraryNumber);
                Utils.printNotification("Thank you! Enjoy the rented product.");
                break;
            case NUMBER_OF_RETURN_OPTION:
                if(!isThePositionOfObjectValidToReturn(positionOfTheObjectInTheList)) {
                    Utils.printNotification("That is not a valid rented product to return.");
                    break;
                }
                librarian.returnObject(positionOfTheObjectInTheList);
                Utils.printNotification("Thank you for returning the rented product.");
                break;
            case NUMBER_OF_VIEW_USER_INFORMATION_OPTION:
                Utils.print(librarian.findUserInCatalogByLibrarianNumber(libraryNumber).toString());
                break;
        }
    }

    private boolean isValidYourPosition(int positionOfTheObjectInTheList) {
        return positionOfTheObjectInTheList > 0;
    }

    private boolean isThePositionOfObjectValidToCheckOut(int positionOfTheObjectInTheList) {
        return isThePositionOnTheRangeOfList(positionOfTheObjectInTheList) && !librarian.getObjectCatalog().getObjectsToRent().get(positionOfTheObjectInTheList).isCheckedOut();
    }

    private boolean isThePositionOfObjectValidToReturn(int positionOfTheObjectInTheList) {
        return isThePositionOnTheRangeOfList(positionOfTheObjectInTheList) && librarian.getObjectCatalog().getObjectsToRent().get(positionOfTheObjectInTheList).isCheckedOut();
    }

    private boolean isThePositionOnTheRangeOfList(int position) {
        return position >= 0 && position < librarian.getObjectCatalog().getObjectsToRent().size();
    }
}
