package com.example.demo1.database;

import javafx.beans.property.SimpleStringProperty;

public class Teachers {
    private static final String ID = "id";
    private static final String SURNAME = "surname";
    private static final String NAME = "name";
    private static final String PATRONYM = "patronym";
    private static final String ACCOUNT = "account";
    private static final String INFO = "info";

    private SimpleStringProperty id;
    private SimpleStringProperty surname;
    private SimpleStringProperty name;
    private SimpleStringProperty patronym;
    private SimpleStringProperty account;
    private SimpleStringProperty info;

    public Teachers(String id, String surname, String name, String patronym, String account, String info) {
        this.id = new SimpleStringProperty(id);
        this.surname = new SimpleStringProperty(surname);
        this.name = new SimpleStringProperty(name);
        this.patronym = new SimpleStringProperty(patronym);
        this.account = new SimpleStringProperty(account);
        this.info = new SimpleStringProperty(info);
    }

    public String getId() {
        return id.get();
    }
    public String getSurname() {
        return surname.get();
    }
    public String getName() {
        return name.get();
    }
    public String getPatronym() {
        return patronym.get();
    }
    public String getAccount() {
        return account.get();
    }
    public String getInfo() {
        return info.get();
    }
    public void setId(String id) {
        this.id.set(id);
    }
    public void setSurname(String surname) {
        this.surname.set(surname);
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public void setPatronym(String patronym) {
        this.patronym.set(patronym);
    }
    public void setAccount(String account) {
        this.account.set(account);
    }
    public void setInfo(String info) {
        this.info.set(info);
    }
}
