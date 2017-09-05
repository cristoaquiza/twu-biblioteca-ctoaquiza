package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testBookEqualsMethod() {
        Book bookActual = new Book("MyBook2", "MyAuthor", 1900);
        Book bookExpected = new Book("MyBook", "MyAuthor", 1900);
        assertEquals("failure - books do not have same fields", bookExpected, bookActual);
    }
}
