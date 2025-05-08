package com.example.demo1.database;

import javafx.beans.property.SimpleStringProperty;

public class Tablegrades {
    private SimpleStringProperty student;
    private SimpleStringProperty subject;
    private SimpleStringProperty year;
    private SimpleStringProperty month;
    private SimpleStringProperty[] grades;

    public Tablegrades(String student, String subject, String year, String month) {
        this.student = new SimpleStringProperty(student);
        this.subject = new SimpleStringProperty(subject);
        this.year = new SimpleStringProperty(year);
        this.month = new SimpleStringProperty(month);
        this.grades = new SimpleStringProperty[31];
    }

    public String getStudent() {
        return student.get();
    }
    public void setStudent(String student) {
        this.student.set(student);
    }
    public String getSubject() {
        return subject.get();
    }
    public void setSubject(String subject) {
        this.subject.set(subject);
    }
    public String getYear() {
        return year.get();
    }
    public void setYear(String year) {
        this.year.set(year);
    }
    public String getMonth() {
        return month.get();
    }
    public void setMonth(String month) {
        this.month.set(month);
    }
    public SimpleStringProperty getGrade(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day must be between 1 and 31");
        }
        return grades[day - 1]; // Возвращаем оценку за день (индексируем с 0)
    }
    public void setGrade(int day, SimpleStringProperty grade) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day must be between 1 and 31");
        }
        grades[day - 1] = grade; // Устанавливаем оценку за день
    }
}
