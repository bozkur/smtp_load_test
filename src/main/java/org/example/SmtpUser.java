package org.example;

public class SmtpUser {
    private final String username;
    private final String password;


    public SmtpUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
