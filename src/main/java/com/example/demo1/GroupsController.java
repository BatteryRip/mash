package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private Button buttonCategories;

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
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> tableId;

    @FXML
    private TableColumn<?, ?> tableName;

    @FXML
    void initialize() {
        assert buttonAdd != null : "fx:id=\"buttonAdd\" was not injected: check your FXML file 'groups.fxml'.";
        assert buttonCategories != null : "fx:id=\"buttonCategories\" was not injected: check your FXML file 'groups.fxml'.";
        assert buttonChange != null : "fx:id=\"buttonChange\" was not injected: check your FXML file 'groups.fxml'.";
        assert buttonSearch != null : "fx:id=\"buttonSearch\" was not injected: check your FXML file 'groups.fxml'.";
        assert comboGroup != null : "fx:id=\"comboGroup\" was not injected: check your FXML file 'groups.fxml'.";
        assert comboMonth != null : "fx:id=\"comboMonth\" was not injected: check your FXML file 'groups.fxml'.";
        assert comboSubject != null : "fx:id=\"comboSubject\" was not injected: check your FXML file 'groups.fxml'.";
        assert fieldSearch != null : "fx:id=\"fieldSearch\" was not injected: check your FXML file 'groups.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'groups.fxml'.";
        assert tableId != null : "fx:id=\"tableId\" was not injected: check your FXML file 'groups.fxml'.";
        assert tableName != null : "fx:id=\"tableName\" was not injected: check your FXML file 'groups.fxml'.";

    }

}
