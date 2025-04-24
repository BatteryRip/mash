package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChangeStudentsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonChange;

    @FXML
    private Button buttonDelete;

    @FXML
    private ComboBox<?> fieldGroup;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldPatronym;

    @FXML
    private TextField fieldSurname;

    @FXML
    private Label labelId;

    @FXML
    void initialize() {
        assert buttonChange != null : "fx:id=\"buttonChange\" was not injected: check your FXML file 'change-students.fxml'.";
        assert buttonDelete != null : "fx:id=\"buttonDelete\" was not injected: check your FXML file 'change-students.fxml'.";
        assert fieldGroup != null : "fx:id=\"fieldGroup\" was not injected: check your FXML file 'change-students.fxml'.";
        assert fieldName != null : "fx:id=\"fieldName\" was not injected: check your FXML file 'change-students.fxml'.";
        assert fieldPatronym != null : "fx:id=\"fieldPatronym\" was not injected: check your FXML file 'change-students.fxml'.";
        assert fieldSurname != null : "fx:id=\"fieldSurname\" was not injected: check your FXML file 'change-students.fxml'.";
        assert labelId != null : "fx:id=\"labelId\" was not injected: check your FXML file 'change-students.fxml'.";

    }

}
