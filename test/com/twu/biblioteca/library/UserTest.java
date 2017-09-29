package com.twu.biblioteca.library;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class UserTest {
    @Test
    public void testTheUserHasLibraryNumberAndPasswordOfUserAsFields() {
        User user = new User();
        assertThat(user.getLibraryNumber(), instanceOf(String.class));
        assertThat(user.getPassword(), instanceOf(String.class));
    }
}
