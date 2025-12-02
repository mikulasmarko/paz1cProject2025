package org.example.Controllers.Sk;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class QRcodeLoginSkController {

    @FXML
    private Button cancelButtonSk;

    @FXML
    private TextField inputNumberSk;

    @FXML
    private Button loginButtonSk;

    @FXML
    void initialize() {
        cancelButtonSk.setOnAction(event -> switchScene("/org/example/sk/mainScreenSk.fxml"));
    }

    private void switchScene(String fxmlPath) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource(fxmlPath));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) loginButtonSk.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
