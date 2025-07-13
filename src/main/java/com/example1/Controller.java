package com.example1;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    //Esta anotación lo que hace es pasar todos los valores que se encuentran en fxml a esta clase, permitiendo acceder a ellos
    @FXML
    private Circle myCircle;
    private double x;
    private double y;

    //Para cambiar de escena debemos de volver a obtener el fxml de la escena en si
    public void switchToScene1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/example1/primary.fxml"));
        //.getSource devuelve el objeto que disparo el evento, por ejemplo un boton
        //(Node)event.getSource() realiza un cast porque getSource() devuelve Object y necesitamos tratarlo como Node, y todos los elementos visuales heredan de Node
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/example1/secondary.fxml"));
        //.getSource devuelve el objeto que disparo el evento, por ejemplo un boton
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void upController(ActionEvent e){
        System.out.println("UP!");
        myCircle.setCenterY(y-=10);
    }
    public void downController(ActionEvent e){
        System.out.println("DOWN!");
        myCircle.setCenterY(y+=10);
    }
    public void rightController(ActionEvent e){
        System.out.println("RIGHT!");
        myCircle.setCenterX(x+=10);
    }
    public void leftController(ActionEvent e){
        System.out.println("LEFT!");
        myCircle.setCenterX(x-=10);
    }
}
