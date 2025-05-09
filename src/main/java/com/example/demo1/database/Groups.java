package com.example.demo1.database;

import javafx.beans.property.SimpleStringProperty;

public class Groups {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String TEACHER = "teacher";
    private static final String LEADER = "leader";

    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty teacher;
    private SimpleStringProperty leader;

    private SimpleStringProperty teacherName;
    private SimpleStringProperty leaderName;

    public Groups(String id, String name, String teacher, String leader) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.teacher = new SimpleStringProperty(teacher);
        this.leader = new SimpleStringProperty(leader);
    }

    public Groups(String id, String name, String teacher, String leader, String teacherName, String leaderName) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.teacher = new SimpleStringProperty(teacher);
        this.leader = new SimpleStringProperty(leader);

        this.teacherName = new SimpleStringProperty(teacherName);
        this.leaderName = new SimpleStringProperty(leaderName);
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
    public String getTeacher() {
        return teacher.get();
    }
    public void setTeacher(String teacher) {
        this.teacher.set(teacher);
    }
    public String getLeader() {
        return leader.get();
    }
    public void setLeader(String leader) {
        this.leader.set(leader);
    }

    public String getTeacherName() {
        return teacherName.get();
    }
    public void setTeacherName(String teacherName) {
        this.teacherName.set(teacherName);
    }
    public String getLeaderName() {
        return leaderName.get();
    }
    public void setLeaderName(String leaderName) {
        this.leaderName.set(leaderName);
    }
}
