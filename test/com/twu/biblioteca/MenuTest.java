package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MenuTest {
    private Menu menu;
    private Library library;

    @Before
    public final void setUp() {
        library = new Library();
        menu = new Menu(library);
    }

    @Test
    public void testThatPrintMenuIsNotEmpty() {
        assertTrue("failure - the length of menu print should be > 0", menu.printMenu().length() > 0);
    }

    @Test
    public void checkThaTheMenuHasTheOptionListBooks() {
        assertThat(menu.printMenu().toLowerCase(), containsString("list books"));
    }

    @Test
    public void checkThatTheOptionNumberOneIsAllowedToRun() {
        assertTrue("failed - the option number ONE should be allowed to run", menu.doTheChoice(1));
    }

    @Test
    public void testParserStringInputToInt() {
        assertThat(menu.parseInputToInt("not number"), equalTo(-1));
        assertThat(menu.parseInputToInt("2"), equalTo(2));
    }
}
