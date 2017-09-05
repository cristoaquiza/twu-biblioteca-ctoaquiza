package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MenuTest {
    private Menu menu;

    @Before
    public final void setUp() {
        menu = new Menu();
    }

    @Test
    public void testThatPrintMenuIsNotEmpty() {
        assertTrue("failure - menu string should be > 0", menu.printMenu().length() > 0);
    }

    @Test
    public void checkThaTheMenuHasTheOptionListBooks() {
        assertThat(menu.printMenu().toLowerCase(), containsString("list books"));
    }
}
