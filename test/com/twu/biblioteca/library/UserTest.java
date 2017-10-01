package com.twu.biblioteca.library;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class UserTest {

    User user;

    @Before
    public void setUp() {
        user = new User("my name", "my email", "099999999","my library number", "my password");
    }

    @Test
    public void testTheUserHasNameEmailPhoneLibraryNumberAndPasswordOfUserAsFields() {
        assertThat(user.getName(), instanceOf(String.class));
        assertThat(user.getEmail(), instanceOf(String.class));
        assertThat(user.getPhoneNumber(), instanceOf(String.class));
        assertThat(user.getLibraryNumber(), instanceOf(String.class));
        assertThat(user.getPassword(), instanceOf(String.class));
    }

    @Test
    public void testGetStringOfUserInformation() {
        String nameExpected = "my name";
        String emailExpected = "my email";
        String phoneNumberExpected = "099999999";
        String stringOfUserInformation = user.toString();
        assertThat(stringOfUserInformation, allOf(containsString(nameExpected), containsString(emailExpected), containsString(phoneNumberExpected)));
    }
}
