package org.example.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class loginScreenController {

    @FXML
    private Button darkLightButton;

    @FXML
    private Button languageButtonEN;

    @FXML
    private Button languageButtonSK;

    @FXML
    private Button loginButton;

    @FXML
    private Button registrationButton;

    @FXML
    private Button settingsButton;

	@FXML
	void initialize() {
	}

	@FXML
	void onRegistrationButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/registrationScreen.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) registrationButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
