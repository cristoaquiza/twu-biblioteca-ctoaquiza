package com.twu.biblioteca.library;

public class ObjectToRent {
    protected boolean checkedOut;
    protected String libraryNumberOfLessee;

    public ObjectToRent() {
        this.libraryNumberOfLessee = new String();
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public String getLibraryNumberOfLessee() {
        return libraryNumberOfLessee;
    }

    public void setLibraryNumberOfLessee(String libraryNumberOfLessee) {
        this.libraryNumberOfLessee = libraryNumberOfLessee;
    }
}
