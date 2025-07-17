package com.example1;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Scene1Controller {
    
    @FXML
    TextField nameTextField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void login(ActionEvent e) throws IOException{

        //Para tomar el valor de lo que se va a introducir en el texto debemos:
        String username = nameTextField.getText(); //Esto va a guardar lo que vamos a escribir en el valor de username

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example1/primary.fxml"));
        root = loader.load();

        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            
            @Override
            public void handle(KeyEvent arg0) {
                //Al realizar esto podemos imprimir por pantalla la tecla pulsada
                System.out.println(arg0.getCode());
            }
            
        });
        Scene2Controller scene2 = loader.getController();
        scene2.displayName(username);
        
        // Esta linea no es necesaria root = FXMLLoader.load(getClass().getResource("/com/example1/primary.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void comprarProducto(ActionEvent event){
        System.out.println("WAWA");
    }
}
