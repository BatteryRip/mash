package com.example.demo1;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demo1.database.Accounts;
import com.example.demo1.database.Groups;
import com.example.demo1.database.Students;
import com.example.demo1.database.Teachers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AuthController {

    DatabaseHandler dbHandler = new DatabaseHandler();
    ObservableList<Accounts> list = FXCollections.observableArrayList();
    public void authQuery(String email, String password) throws SQLException, ClassNotFoundException {
        ResultSet res = null;
        String query = "SELECT * FROM accounts WHERE email = '" + email + "' and password = '" + password + "'";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        res = ps.executeQuery();
        list.removeAll(list);
        while (res.next()) {
            list.add(new Accounts(
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4)
            ));
        }
    }

    ObservableList<Students> sList = FXCollections.observableArrayList();
    public void defineStudentQuery(String account) throws SQLException, ClassNotFoundException {
        ResultSet res = null;
        String query = "SELECT * FROM students WHERE account = '" + account + "'";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        res = ps.executeQuery();
        sList.removeAll(sList);
        while (res.next()) {
            sList.add(new Students(
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6)
            ));
        }
    }
    ObservableList<Teachers> tList = FXCollections.observableArrayList();
    public void defineTeacherQuery(String account) throws SQLException, ClassNotFoundException {
        ResultSet res = null;
        String query = "SELECT * FROM teachers WHERE account = '" + account + "'";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        res = ps.executeQuery();
        tList.removeAll(tList);
        while (res.next()) {
            tList.add(new Teachers(
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6)
            ));
        }
    }
    ObservableList<Groups> gList = FXCollections.observableArrayList();
    public void defineGroupQuery(String x) throws SQLException, ClassNotFoundException {
        ResultSet res = null;
        String query = null;
        if (General.relatedStudent.getSgroup() != null) {
            query = "SELECT * FROM groups WHERE id = '" + x + "'";
        }
        else if (General.relatedTeacher.getId() != null) {
            query = "SELECT * FROM groups WHERE teacher = '" + x + "'";
        }
        else {
            return;
        }
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        res = ps.executeQuery();
        gList.removeAll(gList);
        while (res.next()) {
            gList.add(new Groups(
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4)
            ));
        }
    }

    private void loginAccount() {
        if (!list.isEmpty()) {
            Accounts account = list.get(0);
            General.changeAccount(account);
        }
    }

    private void accountInfoLoading() {
        if (!sList.isEmpty()) {
            Students student = sList.get(0);
            General.setRelatedStudent(student);
        }
        else {
            System.out.println("Не студент");
        }
        if (!tList.isEmpty()) {
            Teachers teacher = tList.get(0);
            General.setRelatedTeacher(teacher);
        }
        else {
            System.out.println("Не учитель");
        }
    }
    private void groupInfoLoading() {
        if (!gList.isEmpty()) {
            Groups sgroup = gList.get(0);
            General.setRelatedGroup(sgroup);
        }
        else {
            System.out.println("Нет группы");
        }
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passField;

    @FXML
    void initialize() {
        loginButton.setOnAction(event -> {
            try {
                authQuery(loginField.getText(), passField.getText());
                loginAccount();
                defineStudentQuery(General.selectedAccount.getId());
                defineTeacherQuery(General.selectedAccount.getId());
                accountInfoLoading();
                if (General.relatedStudent.getSgroup() != null) {
                    defineGroupQuery(General.relatedStudent.getSgroup());
                }
                else if (General.relatedTeacher.getId() != null) {
                    defineGroupQuery(General.relatedTeacher.getId());
                }
                groupInfoLoading();
                loginButton.getScene().getWindow().hide();
                General.page("mainpage.fxml", 132, 247, "Страница");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

    }

}
