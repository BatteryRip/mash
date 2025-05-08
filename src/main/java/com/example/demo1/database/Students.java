package com.example.demo1.database;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Students {
    private static final String ID = "id";
    private static final String SURNAME = "surname";
    private static final String NAME = "name";
    private static final String PATRONYM = "patronym";
    private static final String SGROUP = "sgroup";
    private static final String ACCOUNT = "account";

    private SimpleStringProperty id;
    private SimpleStringProperty surname;
    private SimpleStringProperty name;
    private SimpleStringProperty patronym;
    private SimpleStringProperty sgroup;
    private SimpleStringProperty account;

    private SimpleStringProperty sgroupName;

    public Students(String id, String surname, String name, String patronym, String sgroup, String account) {
        this.id = new SimpleStringProperty(id);
        this.surname = new SimpleStringProperty(surname);
        this.name = new SimpleStringProperty(name);
        this.patronym = new SimpleStringProperty(patronym);
        this.sgroup = new SimpleStringProperty(sgroup);
        this.account = new SimpleStringProperty(account);
    }

    public Students(String id, String surname, String name, String patronym, String sgroup, String account, String sgroupName) {
        this.id = new SimpleStringProperty(id);
        this.surname = new SimpleStringProperty(surname);
        this.name = new SimpleStringProperty(name);
        this.patronym = new SimpleStringProperty(patronym);
        this.sgroup = new SimpleStringProperty(sgroup);
        this.account = new SimpleStringProperty(account);

        this.sgroupName = new SimpleStringProperty(sgroupName);
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
    public String getSgroup() {
        return sgroup.get();
    }
    public String getAccount() {
        return account.get();
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
    public void setSgroup(String sgroup) {
        this.sgroup.set(sgroup);
    }
    public void setAccount(String account) {
        this.account.set(account);
    }

    public void setSgroupName(String sgroupName) {
        this.sgroupName.set(sgroupName);
    }
    public String getSgroupName() {
        return sgroupName.get();
    }
}
