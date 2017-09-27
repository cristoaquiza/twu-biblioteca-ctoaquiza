package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class MovieTest {

    @Test
    public void testGetMovieAsAString() {
        Movie movie = new Movie("my book");
        String movieToString = movie.toString().toLowerCase();
        assertThat(movieToString, allOf(containsString("title"), containsString("my book")));
    }
}
