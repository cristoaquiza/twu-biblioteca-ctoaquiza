package com.twu.biblioteca.library.catalog;

import com.twu.biblioteca.library.User;

import java.util.ArrayList;
import java.util.List;

public class UserCatalog {
    public List<User> users = new ArrayList();

    public List<User> getUsers() {
        return users;
    }

    public void uploadUsers(List<User> users) {
        this.users = users;
    }
}
