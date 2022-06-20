package com.testingdevops.elisium.model;

/**
 *
 * @author Fausto Garcia
 */
public class UserInfo {

    private final StringBuilder username;
    private final StringBuilder password;
    private final StringBuilder reference;
    private StringBuilder register;

    public UserInfo() {
        this.username = new StringBuilder();
        this.password = new StringBuilder();
        this.reference = new StringBuilder();
    }

    public String getUsername() {
        return username.toString();
    }

    public void setUsername(String username) {
        this.username.append(username);
    }

    public String getPassword() {
        return password.toString();
    }

    public void setPassword(String password) {
        this.password.append(password);
    }

    public String getReference() {
        return reference.toString();
    }

    public void setReference(String reference) {
        this.reference.append(reference);
    }

    @Override
    public String toString() {
        register = new StringBuilder();
        register.append(getUsername().concat(",").concat(getPassword()).concat(",").concat(getReference()));
        return register.toString();
    }

}
