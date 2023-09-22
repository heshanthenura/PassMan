package com.heshanthenura.passman.Controllers.WebData;

import com.heshanthenura.passman.Database.Services.GetDataService;
import com.heshanthenura.passman.Services.UserManager;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.logging.Logger;

public class WebDataNameController {

    public Logger logger = Logger.getLogger("info-logger");
    public String USER_NAME = UserManager.getInstance().getUsername();


    @FXML
    private Text webDataName;

    public void setWebDataNameText(String newText) {
        webDataName.setText(newText);
    }


    @FXML
    void showWebDataDetails(MouseEvent event) {
        logger.info("Clicked: "+ webDataName.getText());
        new GetDataService().retrieveWebDataByName(USER_NAME,webDataName.getText());
    }


}
