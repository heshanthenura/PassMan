package com.heshanthenura.passman.Services;

import com.heshanthenura.passman.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneService {
    public void changeScene(String fxmlName, Stage stage) throws IOException {
        changeScene(fxmlName, stage, 600, 400); // Provide default values
    }

    public void changeScene(String fxmlName, Stage stage, int w, int h) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(fxmlName));
        Parent root = loader.load();
        Stage newStage = stage;
        javafx.scene.Scene nextScene = new javafx.scene.Scene(root, w, h);
        newStage.setScene(nextScene);
    }

    public void openScene(String fxml,String title,boolean resizable) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(fxml));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setResizable(resizable);
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }

}
