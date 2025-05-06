package com.example.demo1;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChangeSubjectsController {

    DatabaseHandler dbHandler = new DatabaseHandler();

    String sId = SubjectsController.subjectsSelectedId;

    public void changeSubjectQuery() throws SQLException, ClassNotFoundException {
        String query = "UPDATE subjects SET name ='" + fieldName.getText() + "' WHERE id='" + sId + "'";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        ps.executeUpdate();
    }

    public void deleteSubjectQuery() throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM subjects WHERE id='" + sId + "'";
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
    private TextField fieldName;

    @FXML
    private Label labelId;

    @FXML
    void initialize() {
        labelId.setText("ID:" + SubjectsController.subjectsSelectedId);
        buttonChange.setOnAction(event -> {
            try {
                changeSubjectQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        buttonDelete.setOnAction(event -> {
            try {
                deleteSubjectQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
