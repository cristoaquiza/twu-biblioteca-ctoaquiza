package com.twu.biblioteca.library;

import com.twu.biblioteca.library.objectsToRent.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ObjectToRentTest {

    ObjectToRent objectToRent;

    @Before
    public void setUp() {
        objectToRent = new Movie("my movie", 1993, "my director", 10);
    }

    @Test
    public void testTheObjectToRentHasCheckedOutAndLibraryNumberOfUserAsFields() {
        assertThat(objectToRent.isCheckedOut(), instanceOf(Boolean.class));
        assertThat(objectToRent.getLibraryNumberOfLessee(), instanceOf(String.class));
    }

    @Test
    public void testValueOfFieldCheckedOutAfterInitializeWasFalse() {
        assertFalse("failure - the value of checkedOut for default should be false", objectToRent.isCheckedOut());
    }

    @Test
    public void testSetFieldCheckedOutAsTrue() {
        boolean valueExpectedOfFieldCheckedOut = true;
        objectToRent.setCheckedOut(valueExpectedOfFieldCheckedOut);
        assertTrue("failure - the value setting of checkedOut should be true", objectToRent.isCheckedOut());
    }
}
