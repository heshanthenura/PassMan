package com.heshanthenura.passman.Database.Services;

import com.heshanthenura.passman.Database.ConnectDB;
import com.heshanthenura.passman.Services.Crypto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class RegisterService {
    public Logger logger = Logger.getLogger("info-logger");

    public void RegisterUser(String username,String password){
        try (Connection connection = ConnectDB.connect()) {
            String insertUserSQL = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL);
            preparedStatement.setString(1, username); // Set the username dynamically
            preparedStatement.setString(2, new Crypto().sha256Hash(password)); // Set the password dynamically

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 1) {
                logger.info("User added successfully!");
                new DBTableService().createWebDataTable(username);
            } else {
                logger.info("User insertion failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
