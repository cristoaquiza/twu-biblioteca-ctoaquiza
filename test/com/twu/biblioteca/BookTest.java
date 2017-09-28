package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;

public class BookTest {

    @Test
    public void testGetBookAsAString() {
        Book book = new Book("my book", "my author", 1900);
        String bookToString = book.toString().toLowerCase();
        assertThat(bookToString, allOf(containsString("my book"), containsString("my author"), containsString("1900")));
    }
}
