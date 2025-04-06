package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private Button buttonCategories;

    @FXML
    private Button buttonChange;

    @FXML
    private Button buttonSearch;

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
        assert buttonAdd != null : "fx:id=\"buttonAdd\" was not injected: check your FXML file 'students.fxml'.";
        assert buttonCategories != null : "fx:id=\"buttonCategories\" was not injected: check your FXML file 'students.fxml'.";
        assert buttonChange != null : "fx:id=\"buttonChange\" was not injected: check your FXML file 'students.fxml'.";
        assert buttonSearch != null : "fx:id=\"buttonSearch\" was not injected: check your FXML file 'students.fxml'.";
        assert fieldSearch != null : "fx:id=\"fieldSearch\" was not injected: check your FXML file 'students.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'students.fxml'.";
        assert tableId != null : "fx:id=\"tableId\" was not injected: check your FXML file 'students.fxml'.";
        assert tableName != null : "fx:id=\"tableName\" was not injected: check your FXML file 'students.fxml'.";
        assert tableName1 != null : "fx:id=\"tableName1\" was not injected: check your FXML file 'students.fxml'.";
        assert tableName2 != null : "fx:id=\"tableName2\" was not injected: check your FXML file 'students.fxml'.";
        assert tableName3 != null : "fx:id=\"tableName3\" was not injected: check your FXML file 'students.fxml'.";

    }

}
