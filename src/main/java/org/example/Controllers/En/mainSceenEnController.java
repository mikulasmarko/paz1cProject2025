package org.example.Controllers.En;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class mainSceenEnController {

    @FXML
    private Button loginButtonEn;

    @FXML
    private Button registrationButtonEn;

    @FXML
    private Button settingsButtonEn;

    @FXML
    private Button enToSkButton;

    @FXML
    private Button themeButtonEn;

    @FXML
    void initialize() {
        enToSkButton.setOnAction(event -> switchScene("/org/example/sk/mainScreenSk.fxml"));
        loginButtonEn.setOnAction(event -> switchScene("/org/example/en/QRcodeLoginEn.fxml"));
        registrationButtonEn.setOnAction(event -> switchScene("/org/example/en/registrationPageEn.fxml"));
    }

    private void switchScene(String fxmlPath) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource(fxmlPath));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) loginButtonEn.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
