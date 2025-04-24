package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChangeSubjectsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonChange;

    @FXML
    private Button buttonDelete;

    @FXML
    private TextField fieldName;

    @FXML
    private Label labelId;

    @FXML
    void initialize() {
        assert buttonChange != null : "fx:id=\"buttonChange\" was not injected: check your FXML file 'change-subjects.fxml'.";
        assert buttonDelete != null : "fx:id=\"buttonDelete\" was not injected: check your FXML file 'change-subjects.fxml'.";
        assert fieldName != null : "fx:id=\"fieldName\" was not injected: check your FXML file 'change-subjects.fxml'.";
        assert labelId != null : "fx:id=\"labelId\" was not injected: check your FXML file 'change-subjects.fxml'.";

    }

}
