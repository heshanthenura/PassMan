package com.heshanthenura.passman.Database.Services;

import com.heshanthenura.passman.Database.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBTableService {
    public Logger logger = Logger.getLogger("info-logger");

    public void createWebDataTable(String username) {
        String tableName = username + "_WebData";
        try (Connection conn = ConnectDB.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                             + "id INT AUTO_INCREMENT PRIMARY KEY,"
                             + "url VARCHAR(255) NOT NULL,"
                             + "username VARCHAR(255) NOT NULL,"
                             + "password VARCHAR(255) NOT NULL,"
                             + "name VARCHAR(255) NOT NULL" // Add the 'name' column
                             + ")")) {

            // Execute the SQL statement
            preparedStatement.executeUpdate();
            logger.info("Table " + tableName + " created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


