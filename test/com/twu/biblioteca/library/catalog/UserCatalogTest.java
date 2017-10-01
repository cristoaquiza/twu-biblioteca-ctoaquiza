package com.twu.biblioteca.library.catalog;

import com.twu.biblioteca.library.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class UserCatalogTest {

    UserCatalog userCatalog;
    List<User> currentUsers;

    @Before
    public void setUp() {
        userCatalog = new UserCatalog();
        currentUsers = new ArrayList();
        currentUsers.add(new User("name1", "email1", "593123123123","123-4567", "password1"));
        currentUsers.add(new User("name2", "email2", "593123123123","890-1234", "password2"));
        userCatalog.uploadUsers(currentUsers);
    }

    @Test
    public void testUsersListIsNotNull() {
        List users = userCatalog.getUsers();
        assertNotNull("failure - usersList should not be null", users);
    }

    @Test
    public void testUsersListIsNotEmpty() {
        int lengthOfList = userCatalog.getUsers().size();
        assertTrue("failure - objectsToRentList should not be empty", lengthOfList > 0);
    }

    @Test
    public void testObjectsListItemIsAnInstanceOfUser() {
        int indexOfUser0 = 0;
        assertThat(userCatalog.getUsers().get(indexOfUser0), instanceOf(User.class));
    }

    @Test
    public void testUploadObjectsToRentFromListAsAParameter() {
        int indexOfUser0 = 0;
        String expectedLibraryNumberOfUser = "123-4567";
        User currentUser = userCatalog.getUsers().get(indexOfUser0);
        assertEquals("failure - user of users catalog should be equals", currentUser.getLibraryNumber(), expectedLibraryNumberOfUser);
    }
}
