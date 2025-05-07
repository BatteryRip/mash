package com.example.demo1;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChangeTeachersController {

    DatabaseHandler dbHandler = new DatabaseHandler();

    String sId;

    public void changeTeachersQuery() throws SQLException, ClassNotFoundException {
        String query = General.update(sId, "teachers", "surname", fieldSurname.getText()) +
                General.update(sId, "teachers", "name", fieldName.getText()) +
                General.update(sId, "teachers", "patronym", fieldPatronym.getText());
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        ps.executeUpdate();
    }

    public void deleteTeachersQuery() throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM teachers WHERE id = '" + sId + "'";
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
    private TextField fieldPatronym;

    @FXML
    private TextField fieldSurname;

    @FXML
    private Label labelId;

    @FXML
    void initialize() {
        sId = TeachersController.teachersSelectedId;
        labelId.setText("ID:" + sId);
        buttonChange.setOnAction(event -> {
            try {
                changeTeachersQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        buttonDelete.setOnAction(event -> {
            try {
                deleteTeachersQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

    }

}
