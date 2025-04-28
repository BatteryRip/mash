package com.example.demo1;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demo1.database.Accounts;
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

    private void loginAccount(String login, String pass) {
        if (!list.isEmpty()) {
            Accounts account = list.get(0);
            loginButton.getScene().getWindow().hide();
            General.page("mainpage.fxml", 132, 247, "Пылесос умер");
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
                loginAccount(loginField.getText(), passField.getText());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
//            String login = loginField.getText().trim();
//            String pass = passField.getText().trim();
//            loginButton.getScene().getWindow().hide();
//            General.page("mainpage.fxml", 132, 247, "Пылесос умер");
        });

    }

}
