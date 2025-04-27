package com.example.demo1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AuthController {

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
            String login = loginField.getText().trim();
            String pass = passField.getText().trim();
            loginButton.getScene().getWindow().hide();
            General.page("mainpage.fxml", 132, 247, "Пылесос умер");
        });

    }

}
