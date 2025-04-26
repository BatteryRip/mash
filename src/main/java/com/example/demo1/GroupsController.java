package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GroupsController {

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
    private ComboBox<?> comboGroup;

    @FXML
    private ComboBox<?> comboMonth;

    @FXML
    private ComboBox<?> comboSubject;

    @FXML
    private TextField fieldSearch;

    @FXML
    private Label labelTeacher;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> tableId;

    @FXML
    private TableColumn<?, ?> tableName;

    @FXML
    void initialize() {
        buttonAdd.setOnAction(event -> {
            General.page("add-groups.fxml", 200, 115, "Добавить");
        });
        buttonChange.setOnAction(event -> {
            General.page("change-groups.fxml", 200, 115, "Изменить");
        });
    }

}
