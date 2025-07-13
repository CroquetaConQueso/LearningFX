package com.example1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
