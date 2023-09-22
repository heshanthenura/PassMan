module com.heshanthenura.passman {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;


    opens com.heshanthenura.passman to javafx.fxml;
    exports com.heshanthenura.passman;
    exports com.heshanthenura.passman.Controllers;
    opens com.heshanthenura.passman.Controllers to javafx.fxml;
    exports com.heshanthenura.passman.Controllers.WebData;
    opens com.heshanthenura.passman.Controllers.WebData to javafx.fxml;
}