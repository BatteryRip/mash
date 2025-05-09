package com.example.demo1;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChangeGroupsController {

    DatabaseHandler dbHandler = new DatabaseHandler();

    String sId;

    private void changeGroupsQuery() throws SQLException, ClassNotFoundException {
        String query = General.update(sId, "groups", "name", fieldName.getText()) +
                General.update(sId, "groups", "teacher", fieldTeacher.getText()) +
                General.update(sId, "groups", "leader", fieldLeader.getText());
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        ps.executeUpdate();
    }

    private void deleteGroupsQuery() throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM groups WHERE id = '" + sId + "'";
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
    private TextField fieldLeader;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldTeacher;

    @FXML
    private Label labelId;

    @FXML
    void initialize() {
        sId = GroupsController.groupsSelectedId;
        labelId.setText("ID:" + sId);
        buttonChange.setOnAction(event -> {
            try {
                changeGroupsQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        buttonDelete.setOnAction(event -> {
            try {
                deleteGroupsQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

    }

}
