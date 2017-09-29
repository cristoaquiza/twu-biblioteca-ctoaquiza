package com.twu.biblioteca.library;

public class Librarian {
    private Library library;
    public Librarian(Library library) {
        this.library = library;
    }

    public void checkOutObject(int positionOfTheObjectCheckedOut, String libraryNumber) {
        setCheckedOutFieldOfTheObject(positionOfTheObjectCheckedOut, true);
        getLibrary().getObjectsToRent().get(positionOfTheObjectCheckedOut).setLibraryNumberOfLessee(libraryNumber);
    }

    public void returnObject(int positionOfTheObjectReturned) {
        setCheckedOutFieldOfTheObject(positionOfTheObjectReturned, false);
    }

    private void setCheckedOutFieldOfTheObject(int positionOfTheObjectCheckedOut, boolean checkedOut) {
        getLibrary().getObjectsToRent().get(positionOfTheObjectCheckedOut).setCheckedOut(checkedOut);
    }

    public Library getLibrary() {
        return library;
    }
}
