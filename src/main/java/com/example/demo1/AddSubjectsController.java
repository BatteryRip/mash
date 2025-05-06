package com.example.demo1;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddSubjectsController {
    DatabaseHandler dbHandler = new DatabaseHandler();

    public int nextId() throws SQLException, ClassNotFoundException {
        ResultSet res;
        String query = "SELECT TOP 1 * FROM subjects ORDER BY id DESC";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        res = ps.executeQuery();
        if (res.next()) {
            int id = res.getInt("id");
            return id + 1;
        } else {
            return 1;
        }
    }

    public void addSubjectQuery() throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO subjects (name) VALUES ('" + fieldName.getText() + "')";
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
    private TextField fieldName;

    @FXML
    void initialize() {
        buttonAdd.setOnAction(event ->{
            try {
                addSubjectQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

    }

}

