package com.example.demo1.database;

import javafx.beans.property.SimpleStringProperty;

public class Lessons {
    private static final String ID = "id";
    private static final String SUBJECT = "subject";
    private static final String SGROUP = "sgroup";
    private static final String TEACHER = "teacher";
    private static final String TIME = "time";
    private static final String DATE = "date";

    private SimpleStringProperty id;
    private SimpleStringProperty subject;
    private SimpleStringProperty sgroup;
    private SimpleStringProperty teacher;
    private SimpleStringProperty time;
    private SimpleStringProperty date;

    public Lessons(String id, String subject, String sgroup, String teacher, String time, String date) {
        this.id = new SimpleStringProperty(id);
        this.subject = new SimpleStringProperty(subject);
        this.sgroup = new SimpleStringProperty(sgroup);
        this.teacher = new SimpleStringProperty(teacher);
        this.time = new SimpleStringProperty(time);
        this.date = new SimpleStringProperty(date);
    }

    public String getId() {
        return id.get();
    }
    public String getSubject() {
        return subject.get();
    }
    public String getSgroup() {
        return sgroup.get();
    }
    public String getTeacher() {
        return teacher.get();
    }
    public String getTime() {
        return time.get();
    }
    public String getDate() {
        return date.get();
    }
    public void setId(String id) {
        this.id.set(id);
    }
    public void setSubject(String subject) {
        this.subject.set(subject);
    }
    public void setSgroup(String sgroup) {
        this.sgroup.set(sgroup);
    }
    public void setTeacher(String teacher) {
        this.teacher.set(teacher);
    }
    public void setTime(String time) {
        this.time.set(time);
    }
    public void setDate(String date) {
        this.date.set(date);
    }
}
