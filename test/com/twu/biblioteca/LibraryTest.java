package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LibraryTest {

    Library library;
    String welcomeMessage;
    List<ObjectToRent> currentObjectsToRent;

    @Before
    public void setUp() {
        welcomeMessage = Library.getWelcomeMessage().toLowerCase();
        library = new Library();
        currentObjectsToRent= new ArrayList();
        currentObjectsToRent.add(new Book("Book 0", "Author 1", 1991));
        currentObjectsToRent.add(new Book("Book 1", "Author 2", 1992));
        currentObjectsToRent.add(new Movie("Movie 1", 1990, "Director 1", 5));
        library.uploadObjectsToRent(currentObjectsToRent);
    }

    @Test
    public void testThatWelcomeMessageIsNotNull() {
        assertNotNull("failure - welcomeMessage should be not null", welcomeMessage);
    }

    @Test
    public void testWelcomeMessageHasWelcomeWord() {
        assertThat(welcomeMessage, containsString("welcome"));
    }

    @Test
    public void testObjectsToRentListIsNotNull() {
        List objectsToRent = library.getObjectsToRent();
        assertNotNull("failure - objectsToRentList should not be null", objectsToRent);
    }

    @Test
    public void testObjectsToRentListIsNotEmpty() {
        int lengthOfList = library.getObjectsToRent().size();
        assertTrue("failure - objectsToRentList should not be empty", lengthOfList > 0);
    }

    @Test
    public void testObjectsListItemIsAnInstanceOfBook() {
        int indexOfBook0 = 0;
        assertThat(library.getObjectsToRent().get(indexOfBook0), instanceOf(Book.class));
    }

    @Test
    public void testObjectsListItemIsAnInstanceOfMovie() {
        int indexOfMovie1 = 2;
        assertThat(library.getObjectsToRent().get(indexOfMovie1), instanceOf(Movie.class));
    }

    @Test
    public void testGetObjectsToPrintListReadyToPrint() {
        String printing = library.objectsToRentToString();
        assertThat(printing, containsString("Book 0"));
        assertThat(printing, containsString("Book 1"));
        assertThat(printing, containsString("Movie 1"));
    }

    @Test
    public void testThatTheBookChangeItsCheckoutStateFromFalseToTrueWhenCheckedBook() {
        int positionOfTheBookCheckedOut = 0;
        library.doCkeckOutBook(positionOfTheBookCheckedOut);
        Book bookCheckedOut = (Book) library.getObjectsToRent().get(positionOfTheBookCheckedOut);
        assertTrue("failure - the state book should be checkedout (true)", bookCheckedOut.getCheckedOut());
    }

    @Test
    public void checkToDoNotPrintBookCheckedOut() {
        int positionOfTheBookCheckedOut = 0;
        library.doCkeckOutBook(positionOfTheBookCheckedOut);
        assertThat(library.getTheBooksCheckedOutReadyToPrint(), containsString("Book 0"));
    }

    @Test
    public void testThatTheBookChangeItsCheckoutStateFromTrueToFalseWhenReturnBook() {
        int positionOfTheBookCheckedOut = 0;
        library.doReturnBook(positionOfTheBookCheckedOut);
        Book bookReturned = (Book) library.getObjectsToRent().get(positionOfTheBookCheckedOut);
        assertFalse("failure - the state book should be checkedout (false)", bookReturned.getCheckedOut());
    }

    @Test
    public void testUploadObjectsToRentFromListAsAParameter() {
        String expectedBook = "Book 0";
        Book currentBook = (Book) currentObjectsToRent.get(0);
        String expectedMovie = "Movie 1";
        Movie currentMovie = (Movie) currentObjectsToRent.get(2);
        assertEquals("failure - movie of objectsToRent should be equals", currentMovie.name, expectedMovie);
        assertEquals("failure - book of objectsToRent should be equals", currentBook.getTitle(), expectedBook);
    }
}