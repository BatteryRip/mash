package com.example.demo1;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demo1.database.Groups;
import com.example.demo1.database.Students;
import com.example.demo1.database.Subjects;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class StudentsController {

    protected static String studentsSelectedId;
    private void defineStudentsSelectedId() {
        Students selected = table.getSelectionModel().getSelectedItem();
        studentsSelectedId = selected.getId();
    }
    DatabaseHandler dbHandler = new DatabaseHandler();
    ObservableList<Students> list = FXCollections.observableArrayList();
    ObservableList<Groups> gList = FXCollections.observableArrayList();

    private void studentsQuery(String name) throws SQLException, ClassNotFoundException {
        ResultSet res = null;
        String query = "SELECT s.*, g.name FROM students s " +
                "LEFT JOIN groups g ON s.sgroup = g.id " +
                "WHERE CONCAT(s.surname, ' ', s.name, ' ', s.patronym) LIKE '%" + name + "%'";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        res = ps.executeQuery();
        list.removeAll(list);
        while (res.next()) {
            list.add(new Students(
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7)
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
    private Button buttonSelect;

    @FXML
    private TextField fieldSearch;

    @FXML
    private TableView<Students> table;

    @FXML
    private TableColumn<Students, String> tableId;

    @FXML
    private TableColumn<Students, String> tableSurname;

    @FXML
    private TableColumn<Students, String> tableName;

    @FXML
    private TableColumn<Students, String> tablePatronym;

    @FXML
    private TableColumn<Students, String> tableGroup;

    @FXML
    void initialize() {
        tableId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        tableSurname.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSurname()));
        tableName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        tablePatronym.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPatronym()));
        tableGroup.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSgroupName()));
        buttonAdd.setOnAction(event -> {
            General.page("add-students.fxml", 200, 263, "Добавить");
        });
        buttonChange.setOnAction(event -> {
            defineStudentsSelectedId();
            General.page("change-students.fxml", 200, 263, "Изменить");
        });
        buttonSelect.setOnAction(event -> {
            defineStudentsSelectedId();
            General.page("select-students.fxml", 1325, 800, "мазь от геморроя");
        });
        buttonSearch.setOnAction(event -> {
            try {
                studentsQuery(fieldSearch.getText());
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
