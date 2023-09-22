package com.heshanthenura.passman.Database.Services;

import com.heshanthenura.passman.Database.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddDataService {

    public void insertWebData(String username, String url, String webUsername, String webPassword, String name) {
        String tableName = username + "_WebData";

        try (Connection conn = ConnectDB.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(
                     "INSERT INTO " + tableName + " (url, username, password, name) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, url);
            preparedStatement.setString(2, webUsername);
            preparedStatement.setString(3, webPassword);
            preparedStatement.setString(4, name); // Set the 'name' parameter

            preparedStatement.executeUpdate();
            System.out.println("Web data inserted into " + tableName + " successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

