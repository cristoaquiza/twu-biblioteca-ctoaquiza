package com.twu.biblioteca;

public class Librarian {
    private Library library;
    public Librarian(Library library) {
        this.library = library;
    }

    public void checkOutObject(int positionOfTheObjectCheckedOut) {
        getLibrary().getObjectsToRent().get(positionOfTheObjectCheckedOut).setCheckedOut(true);
    }

    public void returnObject(int positionOfTheObjectReturned) {
        getLibrary().getObjectsToRent().get(positionOfTheObjectReturned).setCheckedOut(false);
    }

    public Library getLibrary() {
        return library;
    }
}
