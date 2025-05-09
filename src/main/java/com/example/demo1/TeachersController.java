package com.example.demo1;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demo1.database.Accounts;
import com.example.demo1.database.Subjects;
import com.example.demo1.database.Teachers;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TeachersController {

    protected static String teachersSelectedId;
    private void defineTeachersSelectedId() {
        Teachers selected = table.getSelectionModel().getSelectedItem();
        teachersSelectedId = selected.getId();
    }

    DatabaseHandler dbHandler = new DatabaseHandler();
    ObservableList<Teachers> list = FXCollections.observableArrayList();
    ObservableList<Accounts> list1 = FXCollections.observableArrayList();
//    String tEmail;
    private void teachersQuery(String name) throws SQLException, ClassNotFoundException {
        ResultSet res = null;
        String query = "SELECT t.*, a.email FROM teachers t " +
                "LEFT JOIN accounts a ON t.account = a.id " +
                "WHERE CONCAT(t.surname, ' ', t.name, ' ', t.patronym) LIKE '%" + name + "%'";
//        String query = "SELECT * FROM teachers WHERE CONCAT(surname, ' ', name, ' ', patronym) LIKE '%" + name + "%'";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        res = ps.executeQuery();
        list.removeAll(list);
        while (res.next()) {
            list.add(new Teachers(
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7)
            ));
        }
//        tEmail = res.getString(7);
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
    private TableView<Teachers> table;

    @FXML
    private TableColumn<Teachers, String> tableAccount;

    @FXML
    private TableColumn<Teachers, String> tableId;

    @FXML
    private TableColumn<Teachers, String> tableInfo;

    @FXML
    private TableColumn<Teachers, String> tableName;

    @FXML
    void initialize() {
        tableId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        tableName.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getSurname()) + " "
                + (cellData.getValue().getName()) + " "
                + (cellData.getValue().getPatronym())));
        tableAccount.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        tableInfo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getInfo()));
        buttonAdd.setOnAction(event -> {
            if (General.selectedAccount.getAdmin().equals("1")) {
                General.page("add-teachers.fxml", 200, 214, "Добавить");
            }
            else {
                General.page("warn-permissions.fxml", 190, 65, "Ошибка");
            }
        });
        buttonChange.setOnAction(event -> {
            if (General.selectedAccount.getAdmin().equals("1")) {
                defineTeachersSelectedId();
                General.page("change-teachers.fxml", 200, 214, "Изменить");
            }
            else {
                General.page("warn-permissions.fxml", 190, 65, "Ошибка");
            }
        });
        buttonSearch.setOnAction(event -> {
            try {
                teachersQuery(fieldSearch.getText());
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
