package com.twu.biblioteca.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class UtilsTest {

    @Test
    public void testConvertFromStringToIntWhenTheInputIsAInt() {
        String intAsString = "2";
        int intExpected = 2;
        assertThat(Utils.convertFromStringToInt(intAsString), equalTo(intExpected));
    }

    @Test
    public void testConvertFromStringToIntWhenTheInputIsAString() {
        String notIntAsString = "not number";
        int intExpected = -1;
        assertThat(Utils.convertFromStringToInt(notIntAsString), equalTo(intExpected));
    }
}