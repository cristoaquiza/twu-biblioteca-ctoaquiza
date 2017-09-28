package com.twu.biblioteca;

public class Librarian {
    private Library library;
    public Librarian(Library library) {
        this.library = library;
    }

    public void checkOutObject(int positionOfTheBookCheckedOut) {
        getLibrary().getObjectsToRent().get(positionOfTheBookCheckedOut).setCheckedOut(true);
    }

    public Library getLibrary() {
        return library;
    }
}
