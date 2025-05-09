package com.example.demo1;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddStudentsController {

    DatabaseHandler dbHandler = new DatabaseHandler();

    private void addStudentQuery() throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO students (surname, name, patronym, sgroup) VALUES ('"
                + fieldSurname.getText()
                + "','" + fieldName.getText()
                + "','" + fieldPatronym.getText()
                + "','" + fieldGroup.getText()+ "')";
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
    private TextField fieldGroup;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldPatronym;

    @FXML
    private TextField fieldSurname;

    @FXML
    void initialize() {
        buttonAdd.setOnAction(event -> {
            try {
                addStudentQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

    }

}
