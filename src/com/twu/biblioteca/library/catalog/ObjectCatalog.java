package com.twu.biblioteca.library.catalog;

import com.twu.biblioteca.library.ObjectToRent;

import java.util.List;

public class ObjectCatalog {
    private List<ObjectToRent> objectsToRent;

    public void uploadObjectsToRent(List<ObjectToRent> objectsToRent) {
        this.objectsToRent = objectsToRent;
    }


    public List<ObjectToRent> getObjectsToRent() {
        return objectsToRent;
    }

    @Override
    public String toString() {
        String objectsToString = "\t--- LIST OF OBJECTS TO RENT ---\n";
        int enumerator = 1;
        for (ObjectToRent objectToRent: this.objectsToRent) {
            if(!objectToRent.isCheckedOut()) objectsToString += enumerator + ". " + objectToRent.toString();
            enumerator++;
        }
        objectsToString += "\t--- END LIST OF OBJECTS TO RENT ---\n";
        return objectsToString;
    }
}
