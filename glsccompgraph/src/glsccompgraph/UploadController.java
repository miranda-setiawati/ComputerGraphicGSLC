package glsccompgraph;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class UploadController {

    @FXML
    private ImageView imageViewOriginal; // ImageView untuk gambar asli

    @FXML
    private ImageView imageViewTransformed; // ImageView untuk gambar hasil transformasi

    @FXML
    private ChoiceBox<String> operationChoice;

    @FXML
    private Button processButton;

    private File selectedFile;

    @FXML
    public void initialize() {
        operationChoice.getItems().addAll("Grayscale", "Blur");
        processButton.setDisable(true);

        processButton.setOnAction(e -> processImage());
    }

    @FXML
    public void uploadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            imageViewOriginal.setImage(new Image(selectedFile.toURI().toString()));
            processButton.setDisable(false);
        }
    }

    private void processImage() {
        if (selectedFile != null && operationChoice.getValue() != null) {
            String operation = operationChoice.getValue();
            ImageProcessor processor = new ImageProcessor();

            Image processedImage;
            if ("Grayscale".equals(operation)) {
                processedImage = processor.toGrayscale(selectedFile);
            } else {
                processedImage = processor.toBlur(selectedFile);
            }


            imageViewTransformed.setImage(processedImage);
        }
    }
  
}
