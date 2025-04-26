package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class StudentsController {

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
    private ComboBox<?> fieldGroup;

    @FXML
    private TextField fieldSearch;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> tableId;

    @FXML
    private TableColumn<?, ?> tableName;

    @FXML
    private TableColumn<?, ?> tableName1;

    @FXML
    private TableColumn<?, ?> tableName2;

    @FXML
    private TableColumn<?, ?> tableName3;

    @FXML
    void initialize() {
        buttonAdd.setOnAction(event -> {
            General.page("add-students.fxml", 200, 263, "Добавить");
        });
        buttonChange.setOnAction(event -> {
            General.page("change-students.fxml", 200, 263, "Изменить");
        });
    }

}
