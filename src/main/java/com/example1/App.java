package com.example1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }

}