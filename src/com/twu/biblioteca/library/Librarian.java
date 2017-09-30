package com.twu.biblioteca.library;

import com.twu.biblioteca.library.catalog.ObjectCatalog;
import com.twu.biblioteca.library.catalog.UserCatalog;

public class Librarian {
    private ObjectCatalog objectCatalog;
    private UserCatalog userCatalog;

    public Librarian(ObjectCatalog objectCatalog, UserCatalog userCatalog) {
        this.objectCatalog = objectCatalog;
        this.userCatalog = userCatalog;
    }

    public static String getWelcomeMessage() {
        return "Welcome to The Bangalore Public Library Management System\n\t\t--- BIBLIOTECA IS AVAILABLE ---";
    }

    public void checkOutObject(int positionOfTheObjectCheckedOut, String libraryNumber) {
        setCheckedOutFieldOfTheObject(positionOfTheObjectCheckedOut, true);
        getObjectCatalog().getObjectsToRent().get(positionOfTheObjectCheckedOut).setLibraryNumberOfLessee(libraryNumber);
    }

    public void returnObject(int positionOfTheObjectReturned) {
        setCheckedOutFieldOfTheObject(positionOfTheObjectReturned, false);
    }

    private void setCheckedOutFieldOfTheObject(int positionOfTheObjectCheckedOut, boolean checkedOut) {
        getObjectCatalog().getObjectsToRent().get(positionOfTheObjectCheckedOut).setCheckedOut(checkedOut);
    }

    public ObjectCatalog getObjectCatalog() {
        return objectCatalog;
    }


    public boolean isAuthorizedUser(String libraryNumberExpected, String passwordExpected) {
        for(User user: userCatalog.getUsers()) {
            if(libraryNumberAndPasswordMatch(libraryNumberExpected, passwordExpected, user)) return true;
        }
        return false;
    }

    private boolean libraryNumberAndPasswordMatch(String libraryNumberExpected, String passwordExpected, User user) {
        return user.getLibraryNumber().equals(libraryNumberExpected) && user.getPassword().equals(passwordExpected);
    }
}
