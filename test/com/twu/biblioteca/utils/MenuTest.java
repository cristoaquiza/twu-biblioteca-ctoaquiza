package com.twu.biblioteca.utils;

import com.twu.biblioteca.library.Librarian;
import com.twu.biblioteca.library.ObjectsCatalog;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MenuTest {
    private Menu menu;
    private ObjectsCatalog objectsCatalog;
    private Librarian librarian;

    @Before
    public final void setUp() {
        objectsCatalog = new ObjectsCatalog();
        librarian = new Librarian(objectsCatalog);
        menu = new Menu(librarian);
    }

    @Test
    public void testThatPrintMenuIsNotEmpty() {
        assertTrue("failure - the length of menu print should be > 0", menu.printMenu().length() > 0);
    }

    @Test
    public void checkThaTheMenuHasTheOptionListBooks() {
        assertThat(menu.printMenu().toLowerCase(), containsString("list"));
    }

    @Test
    public void checkThatTheMenuHasTheOptionQuit() {
        assertThat(menu.printMenu().toLowerCase(), containsString("quit"));
    }

    @Test
    public void checkThaTheMenuHasTheOptionCheckOutBook() {
        assertThat(menu.printMenu().toLowerCase(), containsString("checkout"));
    }

    @Test
    public void checkThaTheMenuHasTheOptionReturnBook() {
        assertThat(menu.printMenu().toLowerCase(), containsString("return"));
    }

    @Test
    public void testMenuHasALibrarianAsAField() {
        assertThat(menu.getLibrarian(), instanceOf(Librarian.class));
    }
}
