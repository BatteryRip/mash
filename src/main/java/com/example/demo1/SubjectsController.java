package com.example.demo1;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demo1.database.Accounts;
import com.example.demo1.database.Subjects;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SubjectsController {

    protected static String subjectsSelectedId;
    private void defineSubjectsSelectedId() {
        Subjects selected = table.getSelectionModel().getSelectedItem();
        subjectsSelectedId = selected.getId();
    }

    DatabaseHandler dbHandler = new DatabaseHandler();
    ObservableList<Subjects> list = FXCollections.observableArrayList();
    public void subjectsQuery(String name) throws SQLException, ClassNotFoundException {
        ResultSet res = null;
        String query = "SELECT * FROM subjects WHERE name LIKE '%" + name + "%'";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        res = ps.executeQuery();
        list.removeAll(list);
        while (res.next()) {
            list.add(new Subjects(
                    res.getString(1),
                    res.getString(2)
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
    private TableView<Subjects> table;

    @FXML
    private TableColumn<Subjects, String> tableId;

    @FXML
    private TableColumn<Subjects, String> tableName;

    @FXML
    void initialize() {
        tableId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        tableName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        buttonAdd.setOnAction(event -> {
            General.page("add-subjects.fxml", 200, 115, "Добавить");
        });
        buttonChange.setOnAction(event -> {
            defineSubjectsSelectedId();
            General.page("change-subjects.fxml", 200, 115, "Изменить");
        });
        buttonSearch.setOnAction(event -> {
            try {
                subjectsQuery(fieldSearch.getText());
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
