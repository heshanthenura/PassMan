package com.heshanthenura.passman.Controllers;

import com.heshanthenura.passman.Services.UserManager;
import com.heshanthenura.passman.Services.Validation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class FormController implements Initializable {

     Logger logger = Logger.getLogger("info-logger");
     String username = UserManager.getInstance().getUsername();
    @FXML
    private Text webDataFormConfPassErrorMsg;

    @FXML
    private TextField webDataFormConfPassword;

    @FXML
    private Text webDataFormErrorMsg;
    @FXML
    private TextField webDataFormName;

    @FXML
    private TextField webDataFormPassword;

    @FXML
    private TextField webDataFormURL;

    @FXML
    private TextField webDataFormUsername;

    @FXML
    void saveUserWebData(MouseEvent event) {
        logger.info(username);
        new Validation().ValidateWebUserData(webDataFormName.getText().trim(),webDataFormURL.getText().trim(),webDataFormUsername.getText().trim(),webDataFormPassword.getText().trim(),webDataFormConfPassword.getText().trim(),webDataFormErrorMsg,webDataFormConfPassErrorMsg);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        webDataFormConfPassErrorMsg.setManaged(false);
        webDataFormConfPassErrorMsg.setVisible(false);
        webDataFormErrorMsg.setManaged(false);
        webDataFormErrorMsg.setVisible(false);
    }
}
