package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainpageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAccount;

    @FXML
    private Button buttonGroups;

    @FXML
    private Button buttonStudents;

    @FXML
    private Button buttonSubjects;

    @FXML
    private Button buttonTeachers;

    @FXML
    void initialize() {
        buttonAccount.setOnAction(event -> {
            General.page("account.fxml", 400, 275, "Аккаунт");
        });
        buttonGroups.setOnAction(event -> {
            General.page("groups.fxml", 870, 800, "Учебные группы");
        });
        buttonSubjects.setOnAction(event -> {
            General.page("subjects.fxml", 1200, 800, "Предметы");
        });
        buttonTeachers.setOnAction(event -> {
            General.page("teachers.fxml", 1200, 800, "Преподаватели");
        });
        buttonStudents.setOnAction(event -> {
            General.page("students.fxml", 815, 800, "Ученики");
        });
    }

}
