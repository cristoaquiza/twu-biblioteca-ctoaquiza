package com.twu.biblioteca.library;

import com.twu.biblioteca.library.catalog.ObjectCatalog;
import com.twu.biblioteca.library.catalog.UserCatalog;
import com.twu.biblioteca.library.objectsToRent.Book;
import com.twu.biblioteca.library.objectsToRent.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LibrarianTest {

    ObjectCatalog objectCatalog;
    Librarian librarian;
    String libraryNumberOfLessee;
    UserCatalog userCatalog;

    @Before
    public void setUp() {
        objectCatalog = new ObjectCatalog();
        List<ObjectToRent> currentObjectsToRent= new ArrayList();
        currentObjectsToRent.add(new Book("Book 0", "Author 1", 1991));
        currentObjectsToRent.add(new Movie("Movie 0", 1991, "Director 1",5.4));
        objectCatalog.uploadObjectsToRent(currentObjectsToRent);
        userCatalog = new UserCatalog();
        List<User> currentUsers= new ArrayList();
        currentUsers.add(new User("123-4567", "password1"));
        userCatalog.uploadUsers(currentUsers);
        librarian = new Librarian(objectCatalog, userCatalog);
        libraryNumberOfLessee = "123-4567";
    }

    @Test
    public void testTheObjectChangeItsCheckoutStateFromFalseToTrueWhenCheckedBook() {
        int positionOfTheObjectYouWantToCheckOut = 1;
        librarian.checkOutObject(positionOfTheObjectYouWantToCheckOut, libraryNumberOfLessee);
        ObjectToRent objectCheckedOut = librarian.getObjectCatalog().getObjectsToRent().get(positionOfTheObjectYouWantToCheckOut);
        assertTrue("failure - the state of object should be checked out (true)", objectCheckedOut.isCheckedOut());
    }

    @Test
    public void testTheObjectChangeItsCheckoutStateFromTrueToFalseWhenReturnBook() {
        int positionOfTheObjectYouWantToReturn = 1;
        librarian.returnObject(positionOfTheObjectYouWantToReturn);
        ObjectToRent objectCheckedOut = librarian.getObjectCatalog().getObjectsToRent().get(positionOfTheObjectYouWantToReturn);
        assertFalse("failure - the state of object should be checked out (false)", objectCheckedOut.isCheckedOut());
    }

    @Test
    public void testTheCheckOutActionSetALibraryNumberInTheRentedObject() {
        int positionOfTheBookYouWantToCheckOut = 0;
        librarian.checkOutObject(positionOfTheBookYouWantToCheckOut, libraryNumberOfLessee);
        ObjectToRent rentedObject = librarian.getObjectCatalog().getObjectsToRent().get(positionOfTheBookYouWantToCheckOut);
        assertEquals(rentedObject.getLibraryNumberOfLessee(), libraryNumberOfLessee);
    }

    @Test
    public void testAskIfTheUserIsAuthorizedToSignInWithCorrectCredentials() {
        String libraryNumberExpected = "123-4567";
        String passwordExpected = "password1";
        assertTrue("failure - the user should be authorized (return true)", librarian.isAuthorizedUser(libraryNumberExpected, passwordExpected));
    }

    @Test
    public void testAskIfTheUserIsNotAuthorizedToSignInWithInCorrectLibraryNumber() {
        String libraryNumberExpected = "123-7654";
        String passwordExpected = "password1";
        assertFalse("failure - the user should not be authorized (return false)", librarian.isAuthorizedUser(libraryNumberExpected, passwordExpected));
    }

    @Test
    public void testAskIfTheUserIsNotAuthorizedToSignInWithInCorrectPassword() {
        String libraryNumberExpected = "123-4567";
        String passwordExpected = "passwordxxx";
        assertFalse("failure - the user should not be authorized (return false)", librarian.isAuthorizedUser(libraryNumberExpected, passwordExpected));
    }
}
