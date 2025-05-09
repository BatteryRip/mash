package com.example.demo1;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChangeStudentsController {

    DatabaseHandler dbHandler = new DatabaseHandler();

    String sId;

    private void changeStudentsQuery() throws SQLException, ClassNotFoundException {
        String query = General.update(sId, "students", "surname", fieldSurname.getText()) +
                General.update(sId, "students", "name", fieldName.getText()) +
                General.update(sId, "students", "patronym", fieldPatronym.getText()) +
                General.update(sId, "students", "sgroup", fieldGroup.getText());
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        ps.executeUpdate();
    }

    private void deleteStudentsQuery() throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM students WHERE id = '" + sId + "'";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        ps.executeUpdate();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonChange;

    @FXML
    private Button buttonDelete;

    @FXML
    private TextField fieldGroup;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldPatronym;

    @FXML
    private TextField fieldSurname;

    @FXML
    private Label labelId;

    @FXML
    void initialize() {
        sId = StudentsController.studentsSelectedId;
        labelId.setText("ID:" + sId);
        buttonChange.setOnAction(event -> {
            try {
                changeStudentsQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        buttonDelete.setOnAction(event -> {
            try {
                deleteStudentsQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

    }

}
