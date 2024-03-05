package com.example.demo1;

public class User {
    private String login;
    private String group;
    private String email;
    private String password;

    public User(String login, String email, String group, String password) {
        this.login = login;
        this.group = group;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
