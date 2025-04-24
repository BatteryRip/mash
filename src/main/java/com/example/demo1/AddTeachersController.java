package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddTeachersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldPatronym;

    @FXML
    private TextField fieldSurname;

    @FXML
    void initialize() {
        assert buttonAdd != null : "fx:id=\"buttonAdd\" was not injected: check your FXML file 'add-teachers.fxml'.";
        assert fieldName != null : "fx:id=\"fieldName\" was not injected: check your FXML file 'add-teachers.fxml'.";
        assert fieldPatronym != null : "fx:id=\"fieldPatronym\" was not injected: check your FXML file 'add-teachers.fxml'.";
        assert fieldSurname != null : "fx:id=\"fieldSurname\" was not injected: check your FXML file 'add-teachers.fxml'.";

    }

}
