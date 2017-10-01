package com.twu.biblioteca.library.catalog;

import com.twu.biblioteca.library.Librarian;
import com.twu.biblioteca.library.ObjectToRent;
import com.twu.biblioteca.library.objectsToRent.Book;
import com.twu.biblioteca.library.objectsToRent.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ObjectCatalogTest {

    ObjectCatalog objectCatalog;
    List<ObjectToRent> currentObjectsToRent;
    Librarian librarian;
    String libraryNumberOfLessee;
    UserCatalog userCatalog;

    @Before
    public void setUp() {
        objectCatalog = new ObjectCatalog();
        currentObjectsToRent= new ArrayList();
        currentObjectsToRent.add(new Book("Book 0", "Author 1", 1991));
        currentObjectsToRent.add(new Movie("Movie 1", 1990, "Director 1", 5));
        objectCatalog.uploadObjectsToRent(currentObjectsToRent);
        librarian = new Librarian(objectCatalog, userCatalog);
    }

    @Test
    public void testObjectsToRentListIsNotNull() {
        List objectsToRent = objectCatalog.getObjectsToRent();
        assertNotNull("failure - objectsToRentList should not be null", objectsToRent);
    }

    @Test
    public void testObjectsToRentListIsNotEmpty() {
        int lengthOfList = objectCatalog.getObjectsToRent().size();
        assertTrue("failure - objectsToRentList should not be empty", lengthOfList > 0);
    }

    @Test
    public void testObjectsListItemIsAnInstanceOfBook() {
        int indexOfBook0 = 0;
        assertThat(objectCatalog.getObjectsToRent().get(indexOfBook0), instanceOf(Book.class));
    }

    @Test
    public void testObjectsListItemIsAnInstanceOfMovie() {
        int indexOfMovie1 = 1;
        assertThat(objectCatalog.getObjectsToRent().get(indexOfMovie1), instanceOf(Movie.class));
    }

    @Test
    public void testGetListOfObjectsToRentReadyToPrint() {
        String printing = objectCatalog.toString();
        assertThat(printing, containsString("Book 0"));
        assertThat(printing, containsString("Movie 1"));
    }

    @Test
    public void testUploadObjectsToRentFromListAsAParameter() {
        String expectedTitleOfBook = "Book 0";
        String expectedTitleOfMovie = "Movie 1";
        Book currentBook = (Book) currentObjectsToRent.get(0);
        Movie currentMovie = (Movie) currentObjectsToRent.get(1);
        assertEquals("failure - movie of objectsToRent should be equals", currentMovie.getName(), expectedTitleOfMovie);
        assertEquals("failure - book of objectsToRent should be equals", currentBook.getTitle(), expectedTitleOfBook);
    }

    @Test
    public void testStringOfObjectsListDoNotHaveCheckedOutObjects() {
        int positionOfTheBookYouWantToCheckOut = 0;
        librarian.checkOutObject(positionOfTheBookYouWantToCheckOut, libraryNumberOfLessee);
        String printing = librarian.getObjectCatalog().toString();
        assertThat(printing, not(containsString("Book 0")));
    }
}