package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class BookTest {

    @Test
    public void testBookEquals() {
        Book bookActual = new Book("MyBook", "MyAuthor", 1900);
        Book bookExpected = new Book("MyBook", "MyAuthor", 1900);
        assertTrue("failure - books do not have same fields", bookActual.equals(bookExpected));
    }

    @Test
    public void testBookPrint() {

    }
}
