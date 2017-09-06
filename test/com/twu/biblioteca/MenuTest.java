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
    public void checkThatTheOptionListBooksNumberOneIsAllowedToRun() {
        assertTrue("failure - the option 'list books' number ONE should be allowed to run", menu.doTheChoice(1));
    }

    @Test
    public void checkThatTheMenuHasTheOptionQuit() {
        assertThat(menu.printMenu().toLowerCase(), containsString("quit"));
    }

    @Test
    public void checkThatTheOptionQuitNumberZeroIsAllowedToRun() {
        assertTrue("failed - the option 'quit' number ZERO should be allowed to run", menu.doTheChoice(0));
    }

    @Test
    public void checkThaTheMenuHasTheOptionCheckOutBook() {
        assertThat(menu.printMenu().toLowerCase(), containsString("checkout book"));
    }

    @Test
    public void checkThatTheOptionCheckOutBookNumberTwoIsAllowedToRun() {
        assertTrue("failure - the option 'checkout book' number TWO should be allowed to run", menu.doTheChoice(2));
    }

    @Test
    public void checkThaTheMenuHasTheOptionReturnBook() {
        assertThat(menu.printMenu().toLowerCase(), containsString("return book"));
    }

    @Test
    public void checkThatTheOptionReturnBookNumberThreeIsAllowedToRun() {
        assertTrue("failure - the option 'return book' number THREE should be allowed to run", menu.doTheChoice(3));
    }
}
