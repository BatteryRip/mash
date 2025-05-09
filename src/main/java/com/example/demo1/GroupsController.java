package com.example.demo1;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demo1.database.Groups;
import com.example.demo1.database.Students;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GroupsController {

    protected static String groupsSelectedId;
    private void defineGroupsSelectedId() {
        Groups selected = table.getSelectionModel().getSelectedItem();
        groupsSelectedId = selected.getId();
    }
    DatabaseHandler dbHandler = new DatabaseHandler();
    ObservableList<Groups> list = FXCollections.observableArrayList();

    private void groupsQuery(String name) throws SQLException, ClassNotFoundException {
        ResultSet res = null;
        String query = "SELECT g.*, CONCAT(t.surname, ' ', t.name, ' ', t.patronym), CONCAT(s.surname, ' ', s.name, ' ', s.patronym) FROM groups g " +
                "LEFT JOIN teachers t ON g.teacher = t.id " +
                "LEFT JOIN students s ON g.leader = s.id " +
                "WHERE g.name LIKE '%" + name + "%'";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        res = ps.executeQuery();
        list.removeAll(list);
        while (res.next()) {
            list.add(new Groups(
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6)
            ));
        }
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonChange;

    @FXML
    private Button buttonSearch;

    @FXML
    private TextField fieldSearch;

    @FXML
    private TableView<Groups> table;

    @FXML
    private TableColumn<Groups, String> tableId;

    @FXML
    private TableColumn<Groups, String> tableLeader;

    @FXML
    private TableColumn<Groups, String> tableName;

    @FXML
    private TableColumn<Groups, String> tableTeacher;

    @FXML
    void initialize() {
        tableId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        tableLeader.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLeaderName()));
        tableName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        tableTeacher.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTeacherName()));
        buttonAdd.setOnAction(event -> {
            General.page("add-groups.fxml", 200, 230, "Добавить");
        });
        buttonChange.setOnAction(event -> {
            defineGroupsSelectedId();
            General.page("change-groups.fxml", 200, 230, "Изменить");
        });
        buttonSearch.setOnAction(event -> {
            try {
                groupsQuery(fieldSearch.getText());
                table.getItems().clear();
                table.getItems().addAll(list);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
