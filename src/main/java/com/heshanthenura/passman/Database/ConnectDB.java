package com.heshanthenura.passman.Database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class ConnectDB {
    private static final String JDBC_URL = "jdbc:sqlite:./database/data.db"; // SQLite database file in the current directory
    private static final String DB_USERNAME = ""; // SQLite does not require a username
    private static final String DB_PASSWORD = ""; // SQLite does not require a password
    public static Logger logger = Logger.getLogger("info-logger");
    private static final String DB_DIRECTORY = "./database/";
    private static final String DB_PATH = DB_DIRECTORY + "data.db";
//    public static Connection connect() {
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
//            CreateTableIfNotExists();
//            logger.info("Connected to the SQLite database");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            logger.warning("Error connecting to the SQLite database");
//        }
//        return connection;
//    }


    public static Connection connect() {
        Connection connection = null;
        try {
            File dbDirectory = new File(DB_DIRECTORY);
            if (!dbDirectory.exists()) {
                if (dbDirectory.mkdirs()) {
                    logger.info("Created the database directory: " + DB_DIRECTORY);
                } else {
                    logger.warning("Failed to create the database directory: " + DB_DIRECTORY);
                }
            }

            connection = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
            CreateTableIfNotExists();
            logger.info("Connected to the SQLite database");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.warning("Error connecting to the SQLite database");
        }
        return connection;
    }


    public static void CreateTableIfNotExists() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement statement = connection.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," + // Use INTEGER and AUTOINCREMENT for SQLite
                    "username VARCHAR(255) NOT NULL," +
                    "password VARCHAR(255) NOT NULL" +
                    ");";
            statement.executeUpdate(createTableSQL);
            logger.info("Table 'users' created (if it didn't already exist) in SQLite.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection connection = connect();
        try {
            if (connection != null) {
                connection.close();
                logger.info("Connection to SQLite database closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}