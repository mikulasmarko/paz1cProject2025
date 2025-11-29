package org.example.Controllers.En;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class QRcodeLoginEnController {

    @FXML
    private Button cancelButtonEn;

    @FXML
    private TextField inputNumberEn;

    @FXML
    private Button loginButtonEn;

    @FXML
    void initialize() {
        cancelButtonEn.setOnAction(event -> switchScene("/org/example/en/mainScreenEn.fxml"));
    }

    private void switchScene(String fxmlPath) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource(fxmlPath));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) cancelButtonEn.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
