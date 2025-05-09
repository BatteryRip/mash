package com.example.demo1;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddGroupsController {

    DatabaseHandler dbHandler = new DatabaseHandler();

    private void addGroupQuery() throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO groups (name, leader, teacher) VALUES ('"
                + fieldName.getText()
                + "','" + fieldLeader.getText()
                + "','" + fieldTeacher.getText()+ "')";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        ps.executeUpdate();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private TextField fieldLeader;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldTeacher;

    @FXML
    void initialize() {
        buttonAdd.setOnAction(event -> {
            try {
                addGroupQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

    }

}
