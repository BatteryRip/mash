package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddStudentsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private ComboBox<?> fieldGroup;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldPatronym;

    @FXML
    private TextField fieldSurname;

    @FXML
    void initialize() {
        assert buttonAdd != null : "fx:id=\"buttonAdd\" was not injected: check your FXML file 'add-students.fxml'.";
        assert fieldGroup != null : "fx:id=\"fieldGroup\" was not injected: check your FXML file 'add-students.fxml'.";
        assert fieldName != null : "fx:id=\"fieldName\" was not injected: check your FXML file 'add-students.fxml'.";
        assert fieldPatronym != null : "fx:id=\"fieldPatronym\" was not injected: check your FXML file 'add-students.fxml'.";
        assert fieldSurname != null : "fx:id=\"fieldSurname\" was not injected: check your FXML file 'add-students.fxml'.";

    }

}
