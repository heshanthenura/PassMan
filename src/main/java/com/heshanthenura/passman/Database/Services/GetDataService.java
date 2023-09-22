package com.heshanthenura.passman.Database.Services;

import com.heshanthenura.passman.Database.ConnectDB;
import com.heshanthenura.passman.Services.AddDataToParent;
import com.heshanthenura.passman.Services.WebData.WebDataDetailsNode;
import javafx.scene.layout.VBox;

import java.sql.*;
import java.util.logging.Logger;

public class GetDataService {
    public static Logger logger = Logger.getLogger("info-logger");

    public void retrieveAllWebData(String username, VBox webLinksNameHolder) {
        try{
            webLinksNameHolder.getChildren().clear();
        }catch (Exception e){

        }
        String tableName = username + "_WebData";
        try (Connection conn = ConnectDB.connect();
             Statement stmt = conn.createStatement()) {

            // Define the SQL query to select data
            String sql = "SELECT * FROM " + tableName;

            // Execute the query and get the result set
            ResultSet rs = stmt.executeQuery(sql);

            // Process the result set (you can print or use the data as needed)
            while (rs.next()) {
                int id = rs.getInt("id");
                String url = rs.getString("url");
                String webUsername = rs.getString("username");
                String webPassword = rs.getString("password");
                String webName = rs.getString("name");
                new AddDataToParent().AddDataToWebLinksNameHolder(webName,webLinksNameHolder);
                // Do something with the retrieved data
                logger.info("ID: " + id+" URL: " + url+" Username: " + webUsername+" Password: " + webPassword + " Name: " + webName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retrieveWebDataByName(String username, String webDataName) {
        try (Connection conn = ConnectDB.connect();

             PreparedStatement preparedStatement = conn.prepareStatement(
                     "SELECT * FROM " + username+"_webdata" + " WHERE name = ?")) {

            preparedStatement.setString(1, webDataName);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // Retrieve the data and create a WebData object
                String webUrl = resultSet.getString("url");
                String webUsername = resultSet.getString("username");
                String webPassword = resultSet.getString("password");
                String webName = resultSet.getString("name");
                WebDataDetailsNode.ShowDetails(webName,webUrl,webUsername,webPassword);
                logger.info("Url: "+webUrl+" Username: " + webUsername+" Password: " + webPassword + " Name: " + webName);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
