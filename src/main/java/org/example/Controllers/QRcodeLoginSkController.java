package org.example.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class QRcodeLoginSkController {

    @FXML
    private Button backButtonSk;

    @FXML
    private TextField inputNumberSk;

    @FXML
    private Button loginButtonSk;

    @FXML
    void initialize() {
        backButtonSk.setOnAction(event -> switchScene("/org/example/mainScreenSk.fxml"));
    }

    private void switchScene(String fxmlPath) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource(fxmlPath));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) backButtonSk.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
