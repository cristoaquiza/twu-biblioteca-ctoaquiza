package com.twu.biblioteca.utils;

import com.twu.biblioteca.library.Librarian;
import com.twu.biblioteca.library.catalog.ObjectCatalog;
import com.twu.biblioteca.library.catalog.UserCatalog;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MenuTest {
    private Menu menu;
    private ObjectCatalog objectCatalog;
    private Librarian librarian;
    UserCatalog userCatalog;

    @Before
    public final void setUp() {
        objectCatalog = new ObjectCatalog();
        librarian = new Librarian(objectCatalog, userCatalog);
        menu = new Menu(librarian);
    }

    @Test
    public void testThatPrintMenuIsNotEmpty() {
        assertTrue("failure - the length of menu print should be > 0", menu.getMenuToString().length() > 0);
    }

    @Test
    public void checkThaTheMenuHasTheOptionListBooks() {
        assertThat(menu.getMenuToString().toLowerCase(), containsString("list"));
    }

    @Test
    public void checkThatTheMenuHasTheOptionQuit() {
        assertThat(menu.getMenuToString().toLowerCase(), containsString("quit"));
    }

    @Test
    public void checkThaTheMenuHasTheOptionCheckOutBook() {
        assertThat(menu.getMenuToString().toLowerCase(), containsString("checkout"));
    }

    @Test
    public void checkThaTheMenuHasTheOptionReturnBook() {
        assertThat(menu.getMenuToString().toLowerCase(), containsString("return"));
    }

    @Test
    public void testMenuHasALibrarianAsAField() {
        assertThat(menu.getLibrarian(), instanceOf(Librarian.class));
    }
}
