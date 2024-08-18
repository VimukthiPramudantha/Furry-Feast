package com.example.furryfeast.Model;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private int userId;
    private String password;

    public User(String firstName, String lastName, String email, int userId, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userId = userId;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
