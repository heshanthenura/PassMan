package com.heshanthenura.passman.Controllers;

import com.heshanthenura.passman.Services.SceneService;
import com.heshanthenura.passman.Services.Validation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class LoginController implements Initializable {

    public Logger logger = Logger.getLogger("info-logger");
    public Validation validation = new Validation();

    @FXML
    private Text loginErrLbl;

    @FXML
    private TextField usrInp;

    @FXML
    private TextField passInp;


    @FXML
    void LoginClick(MouseEvent event) throws IOException {
        logger.info("Login Clicked");
        validation.ValidateLogin(usrInp.getText().trim(), passInp.getText().trim(),loginErrLbl);
    }

    @FXML
    void goToRegister(MouseEvent event) throws IOException {
        logger.info("Clicked Goto Register");
        new SceneService().changeScene("register.fxml",(Stage) loginErrLbl.getScene().getWindow(),600,500);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginErrLbl.setVisible(false);
        loginErrLbl.setManaged(false);
    }

}