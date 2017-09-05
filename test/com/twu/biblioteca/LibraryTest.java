package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;

public class LibraryTest {

    @Test
    public void testThatWelcomeMessageIsNotEmpty() {
        Library library = new Library();
        assertTrue(library.salute().length() > 0);
    }

    @Test
    public void testTheContentOfTheWelcomeMessage() {
        Library library = new Library();
        assertThat(library.salute().toLowerCase(), containsString("welcome"));
    }
}
