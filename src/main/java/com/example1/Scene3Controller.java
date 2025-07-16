package com.example1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene3Controller implements Initializable{

    @FXML
    private Button lougoutButton;
    @FXML
    private AnchorPane scene3Pane;
    @FXML
    private Label titleSc3;
    @FXML
    private Label promptSc3;
    @FXML
    private Label labelONOFF;
    @FXML
    private TextField ageFiller;
    @FXML
    private Button buttonSubmitSc3;
    @FXML
    private ImageView imageViewONOFFSc3;
    @FXML
    private CheckBox checkBoxSc3;
    @FXML
    private RadioButton wendyRadioBsc3;
    @FXML
    private RadioButton missyRadioBsc3;
    @FXML
    private RadioButton daisyRadioBsc3;
    @FXML
    private RadioButton leylaRadioBsc3;
    @FXML
    private Label labelRadioSc3;
    @FXML
    private ListView<String> listViewSc3;
    @FXML
    private Label labelListViewSc3;

    private String[] valoresListViewSc3 = {"Coffee","Cheese","Mortadela","Chorizo","ColaCao","Perrito","Bonito","Rape","Dorada","Lubina","Chanquetes","Chupines"}; 
    private String currentChoice;

    private Stage stage;
    private int age;
    private Image myImage1 = new Image(getClass().getResourceAsStream("/com/example1/urgh.jpg"));
    private Image myImage2 = new Image(getClass().getResourceAsStream("/com/example1/argh.jpg"));

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

    public void submit(ActionEvent event) {
        // Text va a devolver un String por lo que debemos de convertir el String a un
        // int
        try {
            age = Integer.parseInt(ageFiller.getText());
            if (age > 18) {
                titleSc3.setText("You are now signed up!");
            } else {
                titleSc3.setText("You must be older than 18 to be able to log");
            }
        }
        // Se puede cazar más de un error y se puede averiguar que errores haciendo
        // Exception y viendo que tipo de error ha sido
        catch (NumberFormatException e) {
            titleSc3.setText("Only numbers can be introduced");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void change(ActionEvent event) {
        if (checkBoxSc3.isSelected()) {
            labelONOFF.setText("ON");
            imageViewONOFFSc3.setImage(myImage2);
        } else {
            labelONOFF.setText("OFF");
            imageViewONOFFSc3.setImage(myImage1);
        }
    }

    public void getName(ActionEvent event){
        if(wendyRadioBsc3.isSelected()){
            labelRadioSc3.setText(wendyRadioBsc3.getText());
        }else if(missyRadioBsc3.isSelected()){
            labelRadioSc3.setText(missyRadioBsc3.getText());
        }else if(daisyRadioBsc3.isSelected()){
            labelRadioSc3.setText(daisyRadioBsc3.getText());
        }else if(leylaRadioBsc3.isSelected()){
            labelRadioSc3.setText(leylaRadioBsc3.getText());
        }else{
            labelRadioSc3.setText("Elige una opción: ");
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        listViewSc3.getItems().addAll(valoresListViewSc3);
        listViewSc3.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                currentChoice = listViewSc3.getSelectionModel().getSelectedItem();
                labelListViewSc3.setText(currentChoice);
            }
            
        });

    }
}
