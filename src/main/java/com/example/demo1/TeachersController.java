package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TeachersController {

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
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> tableAccount;

    @FXML
    private TableColumn<?, ?> tableId;

    @FXML
    private TableColumn<?, ?> tableInfo;

    @FXML
    private TableColumn<?, ?> tableName;

    @FXML
    void initialize() {
        buttonAdd.setOnAction(event -> {
            General.page("add-teachers.fxml", 200, 214, "Добавить");
        });
        buttonChange.setOnAction(event -> {
            General.page("change-teachers.fxml", 200, 214, "Изменить");
        });
    }

}
