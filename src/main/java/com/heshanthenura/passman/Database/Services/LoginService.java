package com.heshanthenura.passman.Database.Services;

import com.heshanthenura.passman.Database.Entities.User;
import com.heshanthenura.passman.Services.SceneService;
import com.heshanthenura.passman.Services.UserManager;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;

public class LoginService {
    public Logger logger = Logger.getLogger("info-logger");

    public void Login(String username, String password, Text loginErrLbl) throws IOException {
        User user = RetrieveUserDetails.RetrieveUserByUsername(username);
        if(user != null){
            if(password.equals(user.getPassword())) {
                logger.info("Login successfully");
                loginErrLbl.setFill(Color.GREEN);
                loginErrLbl.setVisible(true);
                loginErrLbl.setManaged(true);
                loginErrLbl.setText("Login Successfully");
                UserManager.getInstance().setUsername(username);
                new SceneService().changeScene("main.fxml", (Stage) loginErrLbl.getScene().getWindow());
            }
            }else{
            loginErrLbl.setVisible(true);
            loginErrLbl.setManaged(true);
            loginErrLbl.setFill(Color.RED);
            loginErrLbl.setText("Enter Valid Credentials");
            logger.warning("Enter Valid Credentials");
        }
    }

    public static void main(String[] args) throws IOException {

    }

}
