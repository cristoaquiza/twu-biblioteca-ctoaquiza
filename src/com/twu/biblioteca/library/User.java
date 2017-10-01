package com.twu.biblioteca.library;

public class User {

    private String name;
    private String email;
    private String phoneNumber;
    private String libraryNumber;
    private String password;

    public User(String name, String email, String phoneNumber, String libraryNumber, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "--- USER INFORMATION ---\n" +
                getName() + "\t" +
                getEmail() + "\t" +
                getPhoneNumber() +
                "\n--- END USER INFORMATION ---\n";
    }
}
