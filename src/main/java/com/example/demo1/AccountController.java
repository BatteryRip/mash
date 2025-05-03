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
        labelId.setText("ID:" + General.selectedAccount.getId());
        labelLogin.setText(General.selectedAccount.getEmail());
        if (General.selectedAccount.getAdmin().equals("0")) {
            labelAdmin.setText("Пользователь");
        }
        else {
            labelAdmin.setText("Администратор");
        }
        System.out.println(General.selectedAccount.getAdmin());

    }

}
