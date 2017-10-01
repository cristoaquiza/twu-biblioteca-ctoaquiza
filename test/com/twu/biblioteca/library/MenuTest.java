package com.twu.biblioteca.library;

import com.twu.biblioteca.library.Librarian;
import com.twu.biblioteca.library.Menu;
import com.twu.biblioteca.library.catalog.ObjectCatalog;
import com.twu.biblioteca.library.catalog.UserCatalog;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MenuTest {
    Menu menu;
    Librarian librarian;

    @Before
    public final void setUp() {
        ObjectCatalog objectCatalog = new ObjectCatalog();
        UserCatalog userCatalog = new UserCatalog();
        librarian = new Librarian(objectCatalog, userCatalog);
        menu = new Menu(librarian);
    }

    @Test
    public void testMenuToStringIsNotAEmptyString() {
        int lengthOfTheMenuToString = menu.getMenuToString().length();
        assertTrue("failure - the menu print should not be empty", lengthOfTheMenuToString > 0);
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
    public void testTheMenuHasTheOptionViewUserInformation() {
        assertThat(menu.getMenuToString().toLowerCase(), containsString("view user information"));
    }

    @Test
    public void testMenuHasALibrarianAsAField() {
        assertThat(menu.getLibrarian(), instanceOf(Librarian.class));
    }
}
