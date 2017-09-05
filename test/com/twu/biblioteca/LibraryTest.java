package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    private Library library;

    @Before
    public final void setUp() {
        library = new Library();
    }

    @Test
    public void testThatWelcomeMessageIsNotNull() {
        assertNotNull("welcome message should be not null", library.salute());
    }

    @Test
    public void testTheContentOfTheWelcomeMessage() {
        assertThat(library.salute().toLowerCase(), containsString("welcome"));
    }

    @Test
    public void testTheBooksLoadDoesNotReturnNull() {
        assertNotNull("the books load should not return a null", library.loadBooks());
    }

    @Test
    public void testTheBooksLoadDoesNotReturnEmptyList() {
        assertTrue("failure - the books load should return a list with size > 0", library.loadBooks().size() > 0);
    }

    @Test
    public void testThatTheBooksLoadItemIsAnInstanceOfBook() {
        assertThat(library.loadBooks().get(0), instanceOf(Book.class));
    }

    @Test
    public void testThatTheBooksLoadItemHasRobinsonCrusoeBook() {
        assertThat(library.loadBooks(), hasItem(new Book("Robinson Crusoe", "Daniel Defoe", 1719)));
    }

    @Test
    public void testBooksListFieldIsNotNull() {
        assertNotNull("failure - the books list is null", library.getBooks());
    }

    @Test
    public void testThatPrintBooksIsNotEmpty() {
        assertTrue("failure - the lenght of books print should be > 0", library.printBooks().length() > 0);
    }
}