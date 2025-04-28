package com.example.demo1.database;

import javafx.beans.property.SimpleStringProperty;

public class Accounts {
    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String ADMIN = "admin";

    private SimpleStringProperty id;
    private SimpleStringProperty email;
    private SimpleStringProperty password;
    private SimpleStringProperty admin;

    public Accounts(String id, String email, String password, String admin) {
        this.id = new SimpleStringProperty(id);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.admin = new SimpleStringProperty(admin);
    }

    public String getId() {
        return id.get();
    }
    public String getEmail() {
        return email.get();
    }
    public String getPassword() {
        return password.get();
    }
    public String getAdmin() {
        return admin.get();
    }
    public void setId(String id) {
        this.id.set(id);
    }
    public void setEmail(String email) {
        this.email.set(email);
    }
    public void setPassword(String password) {
        this.password.set(password);
    }
    public void setAdmin(String admin) {
        this.admin.set(admin);
    }
}
