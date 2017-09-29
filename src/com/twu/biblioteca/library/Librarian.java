package com.twu.biblioteca.library;

public class Librarian {
    private ObjectsCatalog objectsCatalog;
    public Librarian(ObjectsCatalog objectsCatalog) {
        this.objectsCatalog = objectsCatalog;
    }

    public void checkOutObject(int positionOfTheObjectCheckedOut, String libraryNumber) {
        setCheckedOutFieldOfTheObject(positionOfTheObjectCheckedOut, true);
        getObjectsCatalog().getObjectsToRent().get(positionOfTheObjectCheckedOut).setLibraryNumberOfLessee(libraryNumber);
    }

    public void returnObject(int positionOfTheObjectReturned) {
        setCheckedOutFieldOfTheObject(positionOfTheObjectReturned, false);
    }

    private void setCheckedOutFieldOfTheObject(int positionOfTheObjectCheckedOut, boolean checkedOut) {
        getObjectsCatalog().getObjectsToRent().get(positionOfTheObjectCheckedOut).setCheckedOut(checkedOut);
    }

    public ObjectsCatalog getObjectsCatalog() {
        return objectsCatalog;
    }
}
