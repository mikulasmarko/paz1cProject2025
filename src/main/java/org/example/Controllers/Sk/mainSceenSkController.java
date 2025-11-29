package org.example.Controllers.Sk;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class mainSceenSkController {

    @FXML
    private Button loginButtonSk;

    @FXML
    private Button registrationButtonSk;

    @FXML
    private Button settingsButtonSk;

    @FXML
    private Button skToEnButton;

    @FXML
    private Button themeButtonSk;

    @FXML
    void initialize() {
        loginButtonSk.setOnAction(event -> switchScene("/org/example/sk/QRcodeLoginSk.fxml"));
        registrationButtonSk.setOnAction(event -> switchScene("/org/example/sk/registrationPageSK.fxml"));
        skToEnButton.setOnAction(event -> switchScene("/org/example/en/mainScreenEn.fxml"));
    }

    private void switchScene(String fxmlPath) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource(fxmlPath));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) loginButtonSk.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
