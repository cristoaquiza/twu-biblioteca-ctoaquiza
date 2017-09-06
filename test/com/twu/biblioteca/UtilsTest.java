package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class UtilsTest {
    private Utils utils;

    @Before
    public final void setUp() {
        utils = new Utils();
    }
    @Test
    public void testParserStringInputToInt() {
        assertThat(utils.parseInputToInt("not number"), equalTo(-1));
        assertThat(utils.parseInputToInt("2"), equalTo(2));
    }
}
