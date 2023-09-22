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

public class RegisterController implements Initializable {

    public Logger logger = Logger.getLogger("info-logger");

    @FXML
    private Text registerErrLbl;

    @FXML
    private Text passwordErrLbl;

    @FXML
    private Text usernameErrLbl;

    @FXML
    private TextField regConfPassInp;

    @FXML
    private TextField regPassInp;

    @FXML
    private TextField regUsrInp;

    @FXML
    void RegisterClick(MouseEvent event) {
        new Validation().ValidateRegister(regUsrInp.getText().trim(),regPassInp.getText().trim(),regConfPassInp.getText().trim(),registerErrLbl,usernameErrLbl,passwordErrLbl);
    }


    @FXML
    void goToLogin(MouseEvent event) throws IOException {
        logger.info("Clicked Goto Login");
        new SceneService().changeScene("login.fxml",(Stage) registerErrLbl.getScene().getWindow());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerErrLbl.setVisible(false);
        registerErrLbl.setManaged(false); // Hide and remove from layout calculations
        usernameErrLbl.setVisible(false);
        usernameErrLbl.setManaged(false); // Hide and remove from layout calculations
        passwordErrLbl.setVisible(false);
        passwordErrLbl.setManaged(false);
    }
}