package com.example1;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Scene2Controller {

    // Tiene que tener el nombre del label encontrado en secondary.fxml
    @FXML
    Label textScene2;
    @FXML
    ImageView vistaImage;
    @FXML
    Button buttonImage;

    Image myImage = new Image(getClass().getResourceAsStream("/com/example1/Wendy1.jpg"));
    Image myImage1 = new Image(getClass().getResourceAsStream("/com/example1/Wendy.jpg"));

    private boolean showingFirst = true;

    public void displayName(String username) {
        textScene2.setText("Hello: " + username);
    }

    public void displayImage() {
        if (showingFirst) {
            vistaImage.setImage(myImage);
        } else {
            vistaImage.setImage(myImage1);
        }
        showingFirst = !showingFirst;
    }

    public void goToScene3(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example1/third.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
