package com.twu.biblioteca.library;

import java.util.List;

public class ObjectCatalog {
    private List<ObjectToRent> objectsToRent;

    public static String getWelcomeMessage() {
        return "Welcome to The Bangalore Public ObjectCatalog Management System\n\t\t___ Biblioteca is available ___";
    }

    public void uploadObjectsToRent(List<ObjectToRent> objectsToRent) {
        this.objectsToRent = objectsToRent;
    }


    public List<ObjectToRent> getObjectsToRent() {
        return objectsToRent;
    }

    @Override
    public String toString() {
        String objectsToString = "\n\t--- LIST OF OBJECTS TO RENT ---\n";
        int enumerator = 1;
        for (ObjectToRent objectToRent: this.objectsToRent) {
            if(!objectToRent.isCheckedOut()) objectsToString += enumerator + ". " + objectToRent.toString();
            enumerator++;
        }
        objectsToString += "\t--- END LIST OF OBJECTS TO RENT ---\n\n\n";
        return objectsToString;
    }
}
