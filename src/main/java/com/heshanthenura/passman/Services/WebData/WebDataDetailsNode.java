package com.heshanthenura.passman.Services.WebData;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.util.logging.Logger;

public class WebDataDetailsNode {

    static Logger logger = Logger.getLogger("info-logger");

    @FXML
    public static Text webDataDetailName;

    @FXML
    public static Text webDataDetailPassword;

    @FXML
    public static Text webDataDetailUrl;

    @FXML
    public static Text webDataDetailUsername;


    public static Text getWebDataDetailName() {
        return webDataDetailName;
    }

    public static void setWebDataDetailName(Text webDataDetailName) {
        WebDataDetailsNode.webDataDetailName = webDataDetailName;
    }

    public static Text getWebDataDetailPassword() {
        return webDataDetailPassword;
    }

    public static void setWebDataDetailPassword(Text webDataDetailPassword) {
        WebDataDetailsNode.webDataDetailPassword = webDataDetailPassword;
    }

    public static Text getWebDataDetailUrl() {
        return webDataDetailUrl;
    }

    public static void setWebDataDetailUrl(Text webDataDetailUrl) {
        WebDataDetailsNode.webDataDetailUrl = webDataDetailUrl;
    }

    public static Text getWebDataDetailUsername() {
        return webDataDetailUsername;
    }

    public static void setWebDataDetailUsername(Text webDataDetailUsername) {
        WebDataDetailsNode.webDataDetailUsername = webDataDetailUsername;
    }

    public static void ShowDetails(String name,String url,String username,String password){
        webDataDetailName.setText(name);
        webDataDetailUrl.setText(url);
        webDataDetailUsername.setText(username);
        webDataDetailPassword.setText(password);
        webDataDetailName.setManaged(true);
        webDataDetailName.setVisible(true);
        webDataDetailUrl.setManaged(true);
        webDataDetailUrl.setVisible(true);
        webDataDetailUsername.setManaged(true);
        webDataDetailUsername.setVisible(true);
        webDataDetailPassword.setManaged(true);
        webDataDetailPassword.setVisible(true);
        logger.info("All Data Set");

    }
    public static void HideDetails(){
        webDataDetailName.setManaged(false);
        webDataDetailName.setVisible(false);
        webDataDetailUrl.setManaged(false);
        webDataDetailUrl.setVisible(false);
        webDataDetailUsername.setManaged(false);
        webDataDetailUsername.setVisible(false);
        webDataDetailPassword.setManaged(false);
        webDataDetailPassword.setVisible(false);

    }

}
