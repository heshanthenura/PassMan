package com.heshanthenura.passman.Services;

import com.heshanthenura.passman.Controllers.WebData.WebDataNameController;
import com.heshanthenura.passman.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AddDataToParent {
    public void AddDataToWebLinksNameHolder(String name,VBox WebLinksNameHolder){
        try {
            
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("WebData/webDataName.fxml"));
            Node webDataDesignRoot = loader.load();

            // Access the controller of the loaded FXML
            WebDataNameController designController = loader.getController();

            // Update the text of the Text node in the new design
            designController.setWebDataNameText(name); // Change to the desired text

            // Add the root node of the new design to the linksHolder VBox
            WebLinksNameHolder.getChildren().add(webDataDesignRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
