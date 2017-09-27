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
    List currentBooks;
    List currentMovies;

    @Before
    public void setUp() {
        welcomeMessage = Library.getWelcomeMessage().toLowerCase();
        library = new Library();
        currentBooks = new ArrayList<Book>();
        currentBooks.add(new Book("Book 0", "Author 1", 1991));
        currentBooks.add(new Book("Book 1", "Author 2", 1992));
        library.setBooks(currentBooks);
        currentMovies = new ArrayList();
        currentMovies.add("Movie 1");
        currentMovies.add("Movie 2");
        library.setMovies(currentMovies);
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
    public void testBooksListIsNotNull() {
        List books = library.getBooks();
        assertNotNull("failure - booksList should not be null", books);
    }

    @Test
    public void testUploadBooksFromListAsAParameter() {
        List expectedList = library.getBooks();
        assertEquals("failure - bookList items should be equals", currentBooks.get(0), expectedList.get(0));
    }

    @Test
    public void testBooksListIsNotEmpty() {
        int lengthOfBookList = library.getBooks().size();
        assertTrue("failure - bookList should not be empty", lengthOfBookList > 0);
    }

    @Test
    public void testThatTheBooksLoadItemIsAnInstanceOfBook() {
        assertThat(library.getBooks().get(0), instanceOf(Book.class));
    }

    @Test
    public void testThatTheBooksLoadItemHasRobinsonCrusoeBook() {
        assertThat(library.getBooks(), hasItem(new Book("Book 0", "Author 1", 1991)));
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
        assertThat(library.getTheBooksCheckedOutReadyToPrint(), containsString("Book 0"));
    }

    @Test
    public void testThatTheBookChangeItsCheckoutStateFromTrueToFalse() {
        int positionOfTheBookCheckedOut = 0;
        library.doReturnBook(positionOfTheBookCheckedOut);
        assertFalse("failure - the state book should be checkedout (false)", library.getBooks().get(positionOfTheBookCheckedOut).getCheckedOut());
    }

    @Test
    public void testMoviesListIsNotNull() {
        assertNotNull("failure - moviesList should not be null", library.getMovies());
    }

    @Test
    public void testMoviesListIsNotEmpty() {
        int lengthOfMoviesList = library.getMovies().size();
        assertTrue("failure - movieList should not be empty", lengthOfMoviesList > 0);
    }

    @Test
    public void testUploadMoviesFromListAsAParameter() {
        String expectedItem = "Movie 1";
        assertEquals("failure - bookList items should be equals", currentMovies.get(0), expectedItem);
    }
}