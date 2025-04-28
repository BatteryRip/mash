package com.example.demo1.database;

import javafx.beans.property.SimpleStringProperty;

public class Grades {
    private static final String ID = "id";
    private static final String LESSON = "lesson";
    private static final String STUDENT = "student";
    private static final String GRADE = "grade";

    private SimpleStringProperty id;
    private SimpleStringProperty lesson;
    private SimpleStringProperty student;
    private SimpleStringProperty grade;

    public Grades(String id, String lesson, String student, String grade) {
        this.id = new SimpleStringProperty(id);
        this.lesson = new SimpleStringProperty(lesson);
        this.student = new SimpleStringProperty(student);
        this.grade = new SimpleStringProperty(grade);
    }

    public String getId() {
        return id.get();
    }
    public String getLesson() {
        return lesson.get();
    }
    public String getStudent() {
        return student.get();
    }
    public String getGrade() {
        return grade.get();
    }
    public void setId(String id) {
        this.id.set(id);
    }
    public void setLesson(String lesson) {
        this.lesson.set(lesson);
    }
    public void setStudent(String student) {
        this.student.set(student);
    }
    public void setGrade(String grade) {
        this.grade.set(grade);
    }
}
