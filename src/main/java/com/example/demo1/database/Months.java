package com.example.demo1.database;

import javafx.beans.property.SimpleStringProperty;

public class Months {
    private static final String NAME = "name";

    private SimpleStringProperty name;

    public Months(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
