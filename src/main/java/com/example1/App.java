package com.example1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource( "/com/example1/primary.fxml"));
            Scene scene = new Scene(root);
            
            // Si no necesitamos más de una escena se puede hacer: scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            // Para tener varias escenas, debemos de hacer:
            
            /* 
            String css = this.getClass().getResource("application.css").toExternalForm();
            scene.getStylesheets().add(css);
            */
            //Al tener el css guardado en un String, estos valores pueden ser aplicados en varias escenas, siempre se puede hacer una nueva en el caso de que queramos una completamente
            stage.setScene(scene);
            stage.show();

            //Al usar este método, habilitamos la funcionalidad del método logout al boton X de salir del programa
            
            //Primera iteración stage.setOnCloseRequest(event -> logout(stage));
            //Esto aún así sigue el flujo del programa por lo que, pese a que le demos a cancelar, saldríamos del programa, para esto se realiza:

            stage.setOnCloseRequest(event -> {
                //Esto parara la salida del programa en el caso en el que presionemos cancelar
                event.consume();
                logout(stage);
            
            });

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void logout(Stage stage) {

        // Si queremos establecer alertas para el usuario, podemos hacerlo utilizando
        // esta clase
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("AWOOOOOOOOOOOOOOOOOGA");
        alert.setHeaderText("You are about to leave");
        alert.setContentText("Do you want to save before exiting?: ");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("WOOOOAH");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}