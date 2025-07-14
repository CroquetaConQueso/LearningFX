package com.example1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene3Controller {

    @FXML
    private Button lougoutButton;
    @FXML
    private AnchorPane scene3Pane;

    Stage stage;

    public void logout(ActionEvent event) {

        // Si queremos establecer alertas para el usuario, podemos hacerlo utilizando
        // esta clase
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("AWOOOOOOOOOOOOOOOOOGA");
        alert.setHeaderText("You are about to leave");
        alert.setContentText("Do you want to save before exiting?: ");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scene3Pane.getScene().getWindow();
            System.out.println("WOOOOAH");
            stage.close();
        }
    }
}
