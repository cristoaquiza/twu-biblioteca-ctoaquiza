package com.twu.biblioteca.library;

import com.twu.biblioteca.library.objectsToRent.Book;
import com.twu.biblioteca.library.objectsToRent.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibrarianTest {

    Library library;
    Librarian librarian;

    @Before
    public void setUp() {
        library = new Library();
        List<ObjectToRent> currentObjectsToRent= new ArrayList();
        currentObjectsToRent.add(new Book("Book 0", "Author 1", 1991));
        currentObjectsToRent.add(new Movie("Movie 0", 1991, "Director 1",5.4));
        library.uploadObjectsToRent(currentObjectsToRent);
        librarian = new Librarian(library);
    }

    @Test
    public void testTheObjectChangeItsCheckoutStateFromFalseToTrueWhenCheckedBook() {
        int positionOfTheObjectYouWantToCheckOut = 1;
        librarian.checkOutObject(positionOfTheObjectYouWantToCheckOut);
        ObjectToRent objectCheckedOut = librarian.getLibrary().getObjectsToRent().get(positionOfTheObjectYouWantToCheckOut);
        assertTrue("failure - the state of object should be checked out (true)", objectCheckedOut.isCheckedOut());
    }

    @Test
    public void testTheObjectChangeItsCheckoutStateFromTrueToFalseWhenReturnBook() {
        int positionOfTheObjectYouWantToReturn = 1;
        librarian.returnObject(positionOfTheObjectYouWantToReturn);
        ObjectToRent objectCheckedOut = librarian.getLibrary().getObjectsToRent().get(positionOfTheObjectYouWantToReturn);
        assertFalse("failure - the state of object should be checked out (false)", objectCheckedOut.isCheckedOut());
    }
}
