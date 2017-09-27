package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MovieTest {

    Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("my movie", 1993, "my director", 10);
    }

    @Test
    public void testBookHasTitleAuthorAndYearAsFields() {
        assertThat(movie.name, instanceOf(String.class));
        assertThat(movie.year, instanceOf(Integer.class));
        assertThat(movie.director, instanceOf(String.class));
        assertThat(movie.rating, instanceOf(Integer.class));
    }

    @Test
    public void testGetMovieAsAString() {
        Movie movieExpected = new Movie("my movie", 1993, "my director", 10);
        String movieToString = movie.toString().toLowerCase();
        assertThat(movieToString, allOf(containsString(movieExpected.name), containsString(movieExpected.year + ""), containsString(movieExpected.director), containsString(movieExpected.rating + "")));
    }

    @Test
    public void testCanInitializeMovieWithOutRating() {
        int defaultValueOfInt = 0;
        Movie movieWithOutRating = new Movie("my movie", 1993, "my director");
        assertEquals("failure - rating of movieWithOutRating should be zero", movieWithOutRating.rating, defaultValueOfInt);
    }
}
