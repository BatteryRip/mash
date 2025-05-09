package com.example.demo1;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddSelectStudentsController {

    DatabaseHandler dbHandler = new DatabaseHandler();

    private boolean recordExists(String studentId, String subjectId, String month, String year) throws SQLException, ClassNotFoundException {
        String query = "SELECT COUNT(*) FROM tablegrades WHERE student = ? AND subject = ? AND month = ? AND year = ?";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        ps.setString(1, studentId);
        ps.setString(2, subjectId);
        ps.setString(3, month);
        ps.setString(4, year);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
        return false;
    }


//    private void addQuery(String day) throws SQLException, ClassNotFoundException {
//        String query = "INSERT INTO tablegrades (day" + day + ", month, year, subject, student) " +
//                "VALUES ('" + fieldGrade.getText() + ", " +
//                fieldMonth.getValue() + ", " +
//                fieldYear.getText() + ", " +
//                fieldSubject.getText() + ", " +
//                SelectStudentsController.sId + "');";
//        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
//        ps.executeUpdate();
//    }

    private void addOrUpdateGrade(String day) throws SQLException, ClassNotFoundException {
        String subjectId = fieldSubject.getText(); // Assuming this is the subject ID
        String month = fieldMonth.getValue().toString(); // Get the selected month
        String year = fieldYear.getText(); // Get the year
        String grade = fieldGrade.getText(); // Get the grade
        if (recordExists(SelectStudentsController.sId, subjectId, month, year)) {
            // Update existing record
            String updateQuery = "UPDATE tablegrades SET day" + day + " = ? WHERE student = ? AND subject = ? AND month = ? AND year = ?";
            PreparedStatement ps = dbHandler.getConnection().prepareStatement(updateQuery);
            ps.setString(1, grade);
            ps.setString(2, SelectStudentsController.sId);
            ps.setString(3, subjectId);
            ps.setString(4, month);
            ps.setString(5, year);
            ps.executeUpdate();
        } else {
            // Insert new record
            String insertQuery = "INSERT INTO tablegrades (day" + day + ", month, year, subject, student) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = dbHandler.getConnection().prepareStatement(insertQuery);
            ps.setString(1, grade);
            ps.setString(2, month);
            ps.setString(3, year);
            ps.setString(4, subjectId);
            ps.setString(5, SelectStudentsController.sId);
            ps.executeUpdate();
        }
    }

    private void loadMonths() {
        String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        for (String month : months) {
            fieldMonth.getItems().add(month);
        }
    }

    private void changeQuery(String day) {}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private TextField fieldDay;

    @FXML
    private TextField fieldGrade;

    @FXML
    private ComboBox<String> fieldMonth;

    @FXML
    private TextField fieldSubject;

    @FXML
    private TextField fieldYear;

    @FXML
    void initialize() {
        loadMonths();
        buttonAdd.setOnAction(event -> {
            String day = fieldDay.getText();
            try {
                addOrUpdateGrade(day);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
