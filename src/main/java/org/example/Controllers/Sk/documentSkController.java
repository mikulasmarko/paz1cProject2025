package org.example.Controllers.Sk;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;

public class documentSkController {

    @FXML
    private Button cancelButtonSk;

    @FXML
    private CheckBox documentSignSk;

    @FXML
    private ScrollPane scrollPaneSk;

    @FXML
    void initialize() {
        cancelButtonSk.setOnAction(event -> switchScene("/org/example/sk/registrationPageSk.fxml"));

        try {
            // Load PDF document
            java.io.InputStream inputStream = getClass().getResourceAsStream("/org/example/documents/document.pdf");
            if (inputStream == null) {
                System.err.println("PDF document not found!");
                return;
            }

            org.apache.pdfbox.pdmodel.PDDocument document = org.apache.pdfbox.pdmodel.PDDocument.load(inputStream);
            org.apache.pdfbox.rendering.PDFRenderer renderer = new org.apache.pdfbox.rendering.PDFRenderer(document);

            javafx.scene.layout.VBox pdfContainer = new javafx.scene.layout.VBox(10);
            pdfContainer.setAlignment(javafx.geometry.Pos.CENTER);
            pdfContainer.setPadding(new javafx.geometry.Insets(10));

            for (int i = 0; i < document.getNumberOfPages(); i++) {
                java.awt.image.BufferedImage bufferedImage = renderer.renderImageWithDPI(i, 200); // Render at 200 DPI
                javafx.scene.image.WritableImage fxImage = javafx.embed.swing.SwingFXUtils.toFXImage(bufferedImage,
                        null);
                javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView(fxImage);
                imageView.setPreserveRatio(true);
                imageView.setFitWidth(600);
                // scrollPaneSk.getPrefWidth() - 20 = Adjust width to scroll pane, but i used
                // 600 since it provides better results, tweaks needed

                pdfContainer.getChildren().add(imageView);
            }

            scrollPaneSk.setContent(pdfContainer);
            document.close();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
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
