package com.heshanthenura.passman.Controllers;

import com.heshanthenura.passman.Database.Services.GetDataService;
import com.heshanthenura.passman.Services.SceneService;
import com.heshanthenura.passman.Services.UserManager;
import com.heshanthenura.passman.Services.WebData.WebDataDetailsNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class MainController implements Initializable {


    public Logger logger = Logger.getLogger("info-logger");
    public String USER_NAME = UserManager.getInstance().getUsername();

    @FXML
    private VBox WebLinksNameHolder;

    @FXML
    private Text webDataDetailName;

    @FXML
    private Text webDataDetailPassword;

    @FXML
    private Text webDataDetailUrl;

    @FXML
    private Text webDataDetailUsername;

    @FXML
    void Logout(MouseEvent event) throws IOException {
        UserManager.getInstance().setUsername(null);

        logger.info(USER_NAME);
        new SceneService().changeScene("login.fxml",((Stage) ((Node) event.getSource()).getScene().getWindow()));
    }

    @FXML
    void AddWebData(MouseEvent event) throws IOException {
        logger.info("add data clicked");
        new SceneService().openScene("form.fxml","Add Data",false);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.info(USER_NAME);
        new GetDataService().retrieveAllWebData(USER_NAME,WebLinksNameHolder);
        WebDataDetailsNode.setWebDataDetailName(webDataDetailName);
        WebDataDetailsNode.setWebDataDetailUrl(webDataDetailUrl);
        WebDataDetailsNode.setWebDataDetailUsername(webDataDetailUsername);
        WebDataDetailsNode.setWebDataDetailPassword(webDataDetailPassword);
        WebDataDetailsNode.HideDetails();
    }
}
