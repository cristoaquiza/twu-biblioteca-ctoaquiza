package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class MovieTest {

    Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("my movie", 1993, "my director", 10);
    }

    @Test
    public void testBookHasTitleAuthorAndYearAsFields() {
        assertThat(movie.getName(), instanceOf(String.class));
        assertThat(movie.getYear(), instanceOf(Integer.class));
        assertThat(movie.getDirector(), instanceOf(String.class));
        assertThat(movie.getRating(), instanceOf(Double.class));
        assertThat(movie.isCheckedOut(), instanceOf(Boolean.class));
    }

    @Test
    public void testGetMovieAsAString() {
        Movie movieExpected = new Movie("my movie", 1993, "my director", 10);
        String movieToString = movie.toString().toLowerCase();
        assertThat(movieToString, allOf(containsString(movieExpected.getName()), containsString(movieExpected.getYear() + ""), containsString(movieExpected.getDirector()), containsString(movieExpected.getRating() + "")));
    }

    @Test
    public void testCanInitializeMovieWithOutRating() {
        String expectedRating = "0.0";
        Movie movieWithOutRating = new Movie("my movie", 1993, "my director");
        String currentRating = String.valueOf(movieWithOutRating.getRating());
        assertEquals("failure - rating of movieWithOutRating should be zero", currentRating, expectedRating);
    }

    @Test
    public void testValueOfFieldCheckedOutAfterInitializeWasFalse() {
        assertFalse("failure - the value of checkedOut for default should be false", movie.isCheckedOut());
    }

    @Test
    public void testSetFieldCheckedOutAsTrue() {
        boolean valueExpectedOfFieldCheckedOut = true;
        movie.setCheckedOut(valueExpectedOfFieldCheckedOut);
        assertTrue("failure - the value setting of checkedOut should be true", movie.isCheckedOut());
    }
}
