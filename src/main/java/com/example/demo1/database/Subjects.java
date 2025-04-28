package com.example.demo1.database;

import javafx.beans.property.SimpleStringProperty;

public class Subjects {
    private static final String ID = "id";
    private static final String NAME = "name";

    private SimpleStringProperty id;
    private SimpleStringProperty name;

    public Subjects(String id, String name) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
    }

    public String getId() {
        return id.get();
    }
    public void setId(String id) {
        this.id.set(id);
    }
    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
}
