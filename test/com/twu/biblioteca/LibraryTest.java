package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LibraryTest {

    private Library library;
    String welcomeMessage;

    @Before
    public final void setUp() {
        welcomeMessage = Library.getWelcomeMessage().toLowerCase();
        library = new Library();
    }

    @Test
    public void testThatWelcomeMessageIsNotNull() {
        assertNotNull("failure - welcomeMessage should be not null", welcomeMessage);
    }

    @Test
    public void testTheContentOfTheWelcomeMessage() {
        assertThat(welcomeMessage, containsString("welcome"));
    }

    @Test
    public void testTheBooksLoadDoesNotReturnNull() {
        assertNotNull("failure - the books load should not return a null", library.getBooks());
    }

    @Test
    public void testTheBooksLoadDoesNotReturnEmptyList() {
        assertTrue("failure - the books load should return a list with size > 0", library.getBooks().size() > 0);
    }

    @Test
    public void testThatTheBooksLoadItemIsAnInstanceOfBook() {
        assertThat(library.getBooks().get(0), instanceOf(Book.class));
    }

    @Test
    public void testThatTheBooksLoadItemHasRobinsonCrusoeBook() {
        assertThat(library.getBooks(), hasItem(new Book("Robinson Crusoe", "Daniel Defoe", 1719)));
    }

    @Test
    public void testBooksListFieldIsNotNull() {
        assertNotNull("failure - the books list is null", library.getBooks());
    }

    @Test
    public void testThatPrintBooksIsNotEmpty() {
        assertTrue("failure - the lenght of books print should be > 0", library.getTheBooksListReadyToPrint().length() > 0);
    }

    @Test
    public void testThatTheBookChangeItsCheckoutStateFromFalseToTrue() {
        int positionOfTheBookCheckedOut = 0;
        library.doCkeckOutBook(positionOfTheBookCheckedOut);
        assertTrue("failure - the state book should be checkedout (true)", library.getBooks().get(positionOfTheBookCheckedOut).getCheckedOut());
    }

    @Test
    public void checkToDoNotPrintBookCheckedOut() {
        int positionOfTheBookCheckedOut = 0;
        library.doCkeckOutBook(positionOfTheBookCheckedOut);
        assertThat(library.getTheBooksCheckedOutReadyToPrint(), containsString("Peter and Wendy"));
    }

    @Test
    public void testThatTheBookChangeItsCheckoutStateFromTrueToFalse() {
        int positionOfTheBookCheckedOut = 0;
        library.doReturnBook(positionOfTheBookCheckedOut);
        assertFalse("failure - the state book should be checkedout (false)", library.getBooks().get(positionOfTheBookCheckedOut).getCheckedOut());
    }
}