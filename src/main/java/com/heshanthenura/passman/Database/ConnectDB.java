package com.heshanthenura.passman.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class ConnectDB {
    private static final String JDBC_URL = "jdbc:h2:./database/data.db"; // Database file in the current directory
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";
    public static Logger logger = Logger.getLogger("info-logger");

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
            CreateTableIfNotExists();
            logger.info("Connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.warning("Error connecting to the database");
        }
        return connection;
    }
    public static void CreateTableIfNotExists(){
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD)) {

            Statement statement = connection.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "username VARCHAR(255) NOT NULL," +
                    "password VARCHAR(255) NOT NULL" +
                    ");";
            statement.executeUpdate(createTableSQL);
            logger.info("Table 'users' created (if it didn't already exist).");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Connection connection = connect();
        try {
            if (connection != null) {
                connection.close();
                logger.info("Connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
