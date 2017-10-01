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
        getObjectCatalog().getObjectsToRent().get(positionOfTheObjectCheckedOut).setCheckedOut(true);
        getObjectCatalog().getObjectsToRent().get(positionOfTheObjectCheckedOut).setLibraryNumberOfLessee(libraryNumber);
    }

    public void returnObject(int positionOfTheObjectReturned) {
        getObjectCatalog().getObjectsToRent().get(positionOfTheObjectReturned).setCheckedOut(false);
        getObjectCatalog().getObjectsToRent().get(positionOfTheObjectReturned).setLibraryNumberOfLessee("");
    }

    public ObjectCatalog getObjectCatalog() {
        return objectCatalog;
    }

    public boolean isAuthorizedUser(String libraryNumberExpected, String passwordExpected) {
        for(User user: userCatalog.getUsers()) {
            if(isTheLibraryNumberMatching(libraryNumberExpected, user) && isThePasswordMatching(passwordExpected, user)) return true;
        }
        return false;
    }

    public User findUserInCatalogByLibrarianNumber(String libraryNumber) {
        for(User user: userCatalog.getUsers()) {
            if(isTheLibraryNumberMatching(libraryNumber, user)) return user;
        }
        return null;
    }

    private boolean isTheLibraryNumberMatching(String libraryNumberExpected, User user) {
        return user.getLibraryNumber().equals(libraryNumberExpected);
    }

    private boolean isThePasswordMatching(String passwordExpected, User user) {
        return user.getPassword().equals(passwordExpected);
    }
}