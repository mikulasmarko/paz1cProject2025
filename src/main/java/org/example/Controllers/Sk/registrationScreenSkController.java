package org.example.Controllers.Sk;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class registrationScreenSkController {

    @FXML
    private Button cancelButtonSk;

    @FXML
    private Button registerButtonSk;

    @FXML
    void initialize() {
        cancelButtonSk.setOnAction(event -> switchScene("/org/example/sk/mainScreenSk.fxml"));
        registerButtonSk.setOnAction(event -> switchScene("/org/example/sk/documentSk.fxml"));
    }

    private void switchScene(String fxmlPath) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource(fxmlPath));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) cancelButtonSk.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
