package com.example.kulb_csd214test2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
public class CrudeController implements Initializable {

    public TextField istudentId;
    public TextField istudentName;
    public TextField icollegeName;
    public TextField icollegeRank;
    @FXML
    private TableView<StudentCollege> tableView;
    @FXML
    private TableColumn<StudentCollege, Integer> studentId;
    @FXML
    private TableColumn<StudentCollege, String> studentName;
    @FXML
    private TableColumn<StudentCollege, String> collegeName;
    @FXML
    private TableColumn<StudentCollege, Integer> collegeRank;

    ObservableList<StudentCollege> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentId.setCellValueFactory(new
                PropertyValueFactory<StudentCollege, Integer>("studentId"));
        studentName.setCellValueFactory(new
                PropertyValueFactory<StudentCollege, String>("studentName"));
        collegeName.setCellValueFactory(new
                PropertyValueFactory<StudentCollege, String>("collegeName"));
        collegeRank.setCellValueFactory(new
                PropertyValueFactory<StudentCollege, Integer>("collegeRank"));
        tableView.setItems(list);
    }

    public void Hellobutton(ActionEvent actionEvent) {
        list.clear();
        tableView.setItems(list);
        populateTable();
    }

    public void populateTable() {
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/pc_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM studentenrollment";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int studentId = resultSet.getInt("studentId");
                String studentName = resultSet.getString("studentName");
                String collegeName = resultSet.getString("collegeName");
                int collegeRank = resultSet.getInt("collegeRank");
                tableView.getItems().add(new StudentCollege(studentId, studentName, collegeName,
                        collegeRank));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertData(ActionEvent actionEvent) {
        String getstudentId = istudentId.getText();
        String getstudentName = istudentName.getText();
        String getcollegeName = icollegeName.getText();
        String getcollegeRank = icollegeRank.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/pc_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `studentenrollment`(`studentName`, `collegeName`, `collegeRank`) VALUES ('" + getstudentName + "','" + getcollegeName + "','" + getcollegeRank + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateData(ActionEvent actionEvent) {
        String getstudentId = istudentId.getText();
        String getstudentName = istudentName.getText();
        String getcollegeName = icollegeName.getText();
        String getcollegeRank = icollegeRank.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/pc_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `studentenrollement` SET `name`='" + getstudentName + "',`doctor`='" + getcollegeName + "',`room`='" + getcollegeRank + "' WHERE `id` = '" + getstudentId + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void DeleteData(ActionEvent actionEvent) {
        String getstudentId = istudentId.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/pc_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM studentenrollment WHERE `studentId`= '" + getstudentId + "' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void LoadData(ActionEvent actionEvent) {
        String getstudentId = istudentId.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/pc_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM studentenrollment WHERE `studentId`= '" + getstudentId + "' ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("studentId");
                String name = resultSet.getString("studentName");
                String doctor = resultSet.getString("collegeName");
                String room = resultSet.getString("collegeRank");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}