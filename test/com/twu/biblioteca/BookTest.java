package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;

public class BookTest {

    @Test
    public void testBookEquals() {
        Book bookActual = new Book("MyBook", "MyAuthor", 1900);
        Book bookExpected = new Book("MyBook", "MyAuthor", 1900);
        assertTrue("failure - books do not have same fields", bookActual.equals(bookExpected));
    }

    @Test
    public void testBookPrint() {
        Book book = new Book("MyBook", "MyAuthor", 1900);
        assertThat(book.toString().toLowerCase(), allOf(containsString("title:"), containsString("author:"), containsString("year published:")));
    }
}
