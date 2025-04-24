package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AccountController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonDelete;

    @FXML
    private Label labelAdmin;

    @FXML
    private Label labelId;

    @FXML
    private Label labelLogin;

    @FXML
    private Label labelName;

    @FXML
    private Label labelStatus;

    @FXML
    void initialize() {
        assert buttonDelete != null : "fx:id=\"buttonDelete\" was not injected: check your FXML file 'account.fxml'.";
        assert labelAdmin != null : "fx:id=\"labelAdmin\" was not injected: check your FXML file 'account.fxml'.";
        assert labelId != null : "fx:id=\"labelId\" was not injected: check your FXML file 'account.fxml'.";
        assert labelLogin != null : "fx:id=\"labelLogin\" was not injected: check your FXML file 'account.fxml'.";
        assert labelName != null : "fx:id=\"labelName\" was not injected: check your FXML file 'account.fxml'.";
        assert labelStatus != null : "fx:id=\"labelStatus\" was not injected: check your FXML file 'account.fxml'.";

    }

}
