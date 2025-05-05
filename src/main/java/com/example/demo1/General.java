package com.example.demo1;

import com.example.demo1.database.Accounts;
import com.example.demo1.database.Groups;
import com.example.demo1.database.Students;
import com.example.demo1.database.Teachers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class General {
    public static void page(String fxmlString, int v, int v1, String title) {
        FXMLLoader mpFxmlLoader = new FXMLLoader(General.class.getResource(fxmlString));
        Scene mpScene = null;
        try {
            mpScene = new Scene(mpFxmlLoader.load(), v, v1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage mpStage = new Stage();
        mpStage.setTitle(title);
        mpStage.setResizable(false);
        mpStage.setScene(mpScene);
        mpStage.show();
    }
    public static Accounts selectedAccount = new Accounts(null, null, null, null);
    public static void changeAccount(String id, String email, String password, String admin) {
        selectedAccount.setId(id);
        selectedAccount.setEmail(email);
        selectedAccount.setPassword(password);
        selectedAccount.setAdmin(admin);
    }
    public static void changeAccount(Accounts account) {
        selectedAccount = account;
    }
    public static Students relatedStudent = new Students(null, null, null, null, null, null);
    public static Teachers relatedTeacher = new Teachers(null, null, null, null, null, null);
    public static Groups relatedGroup = new Groups(null, null, null, null);
    public static void setRelatedStudent(Students student) {
        relatedStudent = student;
    }
    public static void setRelatedTeacher(Teachers teacher) {
        relatedTeacher = teacher;
    }
    public static void setRelatedGroup(Groups group) {
        relatedGroup = group;
    }
    public static Students getRelatedStudent() {
        return relatedStudent;
    }
    public static Teachers getRelatedTeacher() {
        return relatedTeacher;
    }
    public static Groups getRelatedGroup() {
        return relatedGroup;
    }

}
