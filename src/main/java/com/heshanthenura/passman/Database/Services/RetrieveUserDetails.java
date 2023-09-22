package com.heshanthenura.passman.Database.Services;

import com.heshanthenura.passman.Database.ConnectDB;
import com.heshanthenura.passman.Database.Entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class RetrieveUserDetails {
    static Logger logger = Logger.getLogger("info-logger");
    public static User RetrieveUserByUsername(String username){
        User user = null;
        Logger logger = Logger.getLogger("info-logger");
        try (Connection connection = ConnectDB.connect()) {

            String selectUserSQL = "SELECT id, username, password FROM users WHERE username = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(selectUserSQL);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user=new User((long) resultSet.getInt("id"),resultSet.getString("username"),resultSet.getString("password"));
                logger.info(user.toString());
            } else {
                user=null;
                logger.info("User not found with username: " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        User user = RetrieveUserByUsername("user");
        logger.info(String.valueOf(user));
    }

}
