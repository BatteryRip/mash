package com.example.demo1;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demo1.database.Months;
import com.example.demo1.database.Tablegrades;
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

public class SelectStudentsController {

    String sId;

    DatabaseHandler dbHandler = new DatabaseHandler();

    private void loadStudentInfo(String studentId) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM students WHERE id = ?";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        ps.setString(1, studentId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String id = rs.getString("id");
            String surname = rs.getString("surname");
            String name = rs.getString("name");
            String patronym = rs.getString("patronym");
            String sgroup = rs.getString("sgroup");
            String account = rs.getString("account");

            String studentInfo = String.format("ID:%s %s %s %s Группа: %s (Аккаунт: %s)",
                    id, surname, name, patronym, sgroup, account);

            labelInfo.setText(studentInfo);
        } else {
            labelInfo.setText("Студент не найден");
        }
    }

    private void loadMonths() throws SQLException, ClassNotFoundException {
        String query = "SELECT name FROM months";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ObservableList<Months> monthsList = FXCollections.observableArrayList();
        while (rs.next()) {
            String monthName = rs.getString("name");
            monthsList.add(new Months(monthName));
        }
        fieldMonth.setItems(monthsList);
    }


    private ObservableList<Tablegrades> gradesList = FXCollections.observableArrayList();
    private void loadGrades(String studentId, String month, String year) throws SQLException, ClassNotFoundException {
        String query = "SELECT subject, day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, " +
                "day11, day12, day13, day14, day15, day16, day17, day18, day19, day20, " +
                "day21, day22, day23, day24, day25, day26, day27, day28, day29, day30, day31 " +
                "FROM tablegrades WHERE student = ? AND month = ? AND year = ?";

        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        ps.setString(1, studentId);
        ps.setString(2, month);
        ps.setString(3, year);
        ResultSet rs = ps.executeQuery();
        gradesList.clear();
        while (rs.next()) {
            String subject = rs.getString("subject");
            Tablegrades tableGrade = new Tablegrades(studentId, subject, year, month);

            for (int day = 1; day <= 31; day++) {
                String grade = rs.getString("day" + day);
                tableGrade.setGrade(day, new SimpleStringProperty(grade));
            }

            gradesList.add(tableGrade);
        }
        table.setItems(gradesList);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonSearch;

    @FXML
    private TableColumn<Tablegrades, String> day1;

    @FXML
    private TableColumn<Tablegrades, String> day10;

    @FXML
    private TableColumn<Tablegrades, String> day11;

    @FXML
    private TableColumn<Tablegrades, String> day12;

    @FXML
    private TableColumn<Tablegrades, String> day13;

    @FXML
    private TableColumn<Tablegrades, String> day14;

    @FXML
    private TableColumn<Tablegrades, String> day15;

    @FXML
    private TableColumn<Tablegrades, String> day16;

    @FXML
    private TableColumn<Tablegrades, String> day17;

    @FXML
    private TableColumn<Tablegrades, String> day18;

    @FXML
    private TableColumn<Tablegrades, String> day19;

    @FXML
    private TableColumn<Tablegrades, String> day2;

    @FXML
    private TableColumn<Tablegrades, String> day20;

    @FXML
    private TableColumn<Tablegrades, String> day21;

    @FXML
    private TableColumn<Tablegrades, String> day22;

    @FXML
    private TableColumn<Tablegrades, String> day23;

    @FXML
    private TableColumn<Tablegrades, String> day24;

    @FXML
    private TableColumn<Tablegrades, String> day25;

    @FXML
    private TableColumn<Tablegrades, String> day26;

    @FXML
    private TableColumn<Tablegrades, String> day27;

    @FXML
    private TableColumn<Tablegrades, String> day28;

    @FXML
    private TableColumn<Tablegrades, String> day29;

    @FXML
    private TableColumn<Tablegrades, String> day3;

    @FXML
    private TableColumn<Tablegrades, String> day30;

    @FXML
    private TableColumn<Tablegrades, String> day31;

    @FXML
    private TableColumn<Tablegrades, String> day4;

    @FXML
    private TableColumn<Tablegrades, String> day5;

    @FXML
    private TableColumn<Tablegrades, String> day6;

    @FXML
    private TableColumn<Tablegrades, String> day7;

    @FXML
    private TableColumn<Tablegrades, String> day8;

    @FXML
    private TableColumn<Tablegrades, String> day9;

    @FXML
    private ComboBox<Months> fieldMonth;

    @FXML
    private TextField fieldYear;

    @FXML
    private Label labelInfo;

    @FXML
    private TableView<Tablegrades> table;

    @FXML
    private TableColumn<Tablegrades, String> tableId;

    @FXML
    private TableColumn<Tablegrades, String> tableName;

    @FXML
    void initialize() {
        sId = StudentsController.studentsSelectedId;
        try {
            loadStudentInfo(sId);
            loadMonths();

            tableId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStudent()));
            tableName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSubject()));

            day1.setCellValueFactory(cellData -> cellData.getValue().getGrade(1));
            day2.setCellValueFactory(cellData -> cellData.getValue().getGrade(2));
            day3.setCellValueFactory(cellData -> cellData.getValue().getGrade(3));
            day4.setCellValueFactory(cellData -> cellData.getValue().getGrade(4));
            day5.setCellValueFactory(cellData -> cellData.getValue().getGrade(5));
            day6.setCellValueFactory(cellData -> cellData.getValue().getGrade(6));
            day7.setCellValueFactory(cellData -> cellData.getValue().getGrade(7));
            day8.setCellValueFactory(cellData -> cellData.getValue().getGrade(8));
            day9.setCellValueFactory(cellData -> cellData.getValue().getGrade(9));
            day10.setCellValueFactory(cellData -> cellData.getValue().getGrade(10));
            day11.setCellValueFactory(cellData -> cellData.getValue().getGrade(11));
            day12.setCellValueFactory(cellData -> cellData.getValue().getGrade(12));
            day13.setCellValueFactory(cellData -> cellData.getValue().getGrade(13));
            day14.setCellValueFactory(cellData -> cellData.getValue().getGrade(14));
            day15.setCellValueFactory(cellData -> cellData.getValue().getGrade(15));
            day16.setCellValueFactory(cellData -> cellData.getValue().getGrade(16));
            day17.setCellValueFactory(cellData -> cellData.getValue().getGrade(17));
            day18.setCellValueFactory(cellData -> cellData.getValue().getGrade(18));
            day19.setCellValueFactory(cellData -> cellData.getValue().getGrade(19));
            day20.setCellValueFactory(cellData -> cellData.getValue().getGrade(20));
            day21.setCellValueFactory(cellData -> cellData.getValue().getGrade(21));
            day22.setCellValueFactory(cellData -> cellData.getValue().getGrade(22));
            day23.setCellValueFactory(cellData -> cellData.getValue().getGrade(23));
            day24.setCellValueFactory(cellData -> cellData.getValue().getGrade(24));
            day25.setCellValueFactory(cellData -> cellData.getValue().getGrade(25));
            day26.setCellValueFactory(cellData -> cellData.getValue().getGrade(26));
            day27.setCellValueFactory(cellData -> cellData.getValue().getGrade(27));
            day28.setCellValueFactory(cellData -> cellData.getValue().getGrade(28));
            day29.setCellValueFactory(cellData -> cellData.getValue().getGrade(29));
            day30.setCellValueFactory(cellData -> cellData.getValue().getGrade(30));
            day31.setCellValueFactory(cellData -> cellData.getValue().getGrade(31));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onSearchButtonClick() {
        Months selectedMonth = (Months) fieldMonth.getValue();
        String month = selectedMonth != null ? selectedMonth.getName() : null;
        String year = fieldYear.getText();
        if (month == null || year.isEmpty()) {
            return;
        }

        try {
            loadGrades(sId, month, year);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
