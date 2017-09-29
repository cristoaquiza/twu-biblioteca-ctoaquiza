package com.twu.biblioteca.library.objectsToRent;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;

public class BookTest {

    Book book;

    @Before
    public void setUp() {
        book = new Book("my book", "my author", 1900);
    }

    @Test
    public void testBookHasTitleAuthorAndYearAsFields() {
        assertThat(book.getTitle(), instanceOf(String.class));
        assertThat(book.getAuthor(), instanceOf(String.class));
        assertThat(book.getYear(), instanceOf(Integer.class));
        assertThat(book.isCheckedOut(), instanceOf(Boolean.class));
    }

    @Test
    public void testGetBookAsAString() {
        String titleExpected = "my book";
        String authorExpected = "my author";
        String yearExpected = "1900";
        String bookToStringGetting = book.toString().toLowerCase();
        assertThat(bookToStringGetting, allOf(containsString(titleExpected), containsString(authorExpected), containsString(yearExpected)));
    }
}
