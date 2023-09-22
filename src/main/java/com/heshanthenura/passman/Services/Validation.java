package com.heshanthenura.passman.Services;

import com.heshanthenura.passman.Controllers.MainController;
import com.heshanthenura.passman.Database.Services.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import static com.heshanthenura.passman.Controllers.MainController.webLinksNameHolder;


public class Validation {

    public Logger logger = Logger.getLogger("info-logger");
    String USER_NAME = UserManager.getInstance().getUsername();
    public boolean ValidateLogin(String username, String password, Text loginErrLbl) throws IOException {

        if (username.isEmpty() || password.isEmpty()) {
            loginErrLbl.setText("Enter valid credentials");
            loginErrLbl.setVisible(true);
            loginErrLbl.setManaged(true);
            return false;
        }


        loginErrLbl.setVisible(false);
        new LoginService().Login(username, new Crypto().sha256Hash(password) , loginErrLbl);
        return true;
    }
    public void ValidateRegister(String username, String password, String confirmPassword, Text registerErrLbl, Text usernameErrLbl, Text passwordErrLbl) {
        registerErrLbl.setVisible(false);
        registerErrLbl.setManaged(false);
        usernameErrLbl.setVisible(false);
        usernameErrLbl.setManaged(false);
        passwordErrLbl.setVisible(false);
        passwordErrLbl.setManaged(false);

        // Define a regular expression pattern for a valid username
        Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9_-]+$");

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            registerErrLbl.setText("Please fill in all fields.");
            registerErrLbl.setVisible(true);
            registerErrLbl.setManaged(true);
        } else if (!usernamePattern.matcher(username).matches()) {
            // Check if the username does not match the pattern
            usernameErrLbl.setText("Username can only contain letters, numbers, hyphens, and underscores.");
            usernameErrLbl.setVisible(true);
            usernameErrLbl.setManaged(true);
        } else {
            if (password.equals(confirmPassword)) {
                logger.info("all good checking username availability");
                Boolean availability = new RetrieveUserDetails().RetrieveUserByUsername(username) == null;
                logger.info("Available: " + availability);
                if (!availability) {
                    logger.info("Username not available");
                    usernameErrLbl.setText("Username not available");
                    usernameErrLbl.setVisible(true);
                    usernameErrLbl.setManaged(true);
                } else {
                    logger.info("All good we can register");
                    new RegisterService().RegisterUser(username, password);
                    registerErrLbl.setText("Registration Successful");
                    registerErrLbl.setFill(Color.GREEN);
                    registerErrLbl.setVisible(true);
                    registerErrLbl.setManaged(true);
                }
            } else {
                logger.info("Passwords don't match");
                passwordErrLbl.setText("Passwords do not match.");
                passwordErrLbl.setVisible(true);
                passwordErrLbl.setManaged(true);
            }
        }
    }
    public void ValidateWebUserData(String name,String url,String username,String password,String confPassword,Text errorMsg,Text confPassErrorMsg){
        confPassErrorMsg.setManaged(false);
        confPassErrorMsg.setVisible(false);
        errorMsg.setManaged(false);
        errorMsg.setVisible(false);
        if (name.isEmpty() || url.isEmpty() || username.isEmpty() || password.isEmpty() || confPassword.isEmpty()) {
            errorMsg.setText("Please fill in all fields.");
            errorMsg.setVisible(true);
            errorMsg.setManaged(true);
            logger.info("Please fill in all fields.");
        } else if (!password.equals(confPassword)) {
            confPassErrorMsg.setText("Passwords do not match.");
            confPassErrorMsg.setVisible(true);
            confPassErrorMsg.setManaged(true);
            logger.info("Passwords do not match.");
        } else {
            // All fields are valid; you can proceed to save the data
            errorMsg.setVisible(false);
            errorMsg.setManaged(false);
            confPassErrorMsg.setVisible(false);
            confPassErrorMsg.setManaged(false);
            logger.info("All good Add data");
            new AddDataService().insertWebData(USER_NAME,url,username,password,name);
            Stage closeStage =(Stage) errorMsg.getScene().getWindow();
            closeStage.close();
            new AddDataToParent().AddDataToWebLinksNameHolder(name,webLinksNameHolder);
        }
    }
}

