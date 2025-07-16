package com.example1;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Scene2Controller implements Initializable {

    // Tiene que tener el nombre del label encontrado en secondary.fxml
    @FXML
    private Label textScene2;
    @FXML
    private ImageView vistaImage;
    @FXML
    private Button buttonImage;
    @FXML
    DatePicker datePickerSc2;
    @FXML
    private Label labelDateSc2;
    @FXML
    private ChoiceBox<String> choiceBoxSc2;
    // Como no se puede añadir un action ni se puede añadir un método a un choicebox
    // desde SceneBuilder. Por esto, debemos de hacerlo todo desde el controller.
    // Primero, establecemos las opciones que iran en el ChoiceBox, el cual va a ser
    // de un tipo definido.
    // Para poder implementar un iniciador en el controlador, debemos de implementar
    // una interfez llamada Initializable
    @FXML
    private Label labelChoiceBox;
    @FXML
    private TreeView<String> treeViewSc2;

    private String[] valuesChoiceBoxSc2 = { "Departamento de Sanidad", "Verengenas", "Cafe" };
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

    public void getDate(ActionEvent event) {
        LocalDate currentDate = datePickerSc2.getValue();
        System.out.println(currentDate.toString());
    }

    // Solo puede haber un único initialize por controller
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Para proporcionar valores al choicebox, debemos de hacer esto:
        choiceBoxSc2.getItems().addAll(valuesChoiceBoxSc2);
        choiceBoxSc2.setOnAction(this::getValue);
        // --------------------------

        // Cuando se realiza un treeview, en el apartado de Code de SceneBuilder,
        // debemos de añadir un metodo en el apartado OnContextMenuRequested y en
        // OnMouseClicked
        TreeItem<String> rootItem = new TreeItem<>("Comida");
        TreeItem<String> branchItem1 = new TreeItem<>("Lacteos");
        TreeItem<String> branchItem2 = new TreeItem<>("Pescado");
        TreeItem<String> branchItem3 = new TreeItem<>("Carne");

        TreeItem<String> branchItem1a = new TreeItem<>("Yoghurt");
        TreeItem<String> branchItem2a = new TreeItem<>("Leche");
        TreeItem<String> branchItem3a = new TreeItem<>("Queso");

        TreeItem<String> branchItem1b = new TreeItem<>("Gambas");
        TreeItem<String> branchItem2b = new TreeItem<>("Sardinas");
        TreeItem<String> branchItem3b = new TreeItem<>("Boquerones");

        TreeItem<String> branchItem1c = new TreeItem<>("Filetes de cerdo");
        TreeItem<String> branchItem2c = new TreeItem<>("Filetes de ternera");
        TreeItem<String> branchItem3c = new TreeItem<>("Carne picada");

        branchItem1.getChildren().addAll(branchItem1a, branchItem2a, branchItem3a);
        branchItem2.getChildren().addAll(branchItem1b, branchItem2b, branchItem3b);
        branchItem3.getChildren().addAll(branchItem1c, branchItem2c, branchItem3c);

        rootItem.getChildren().addAll(branchItem1, branchItem2, branchItem3);

        treeViewSc2.setRoot(rootItem);

    }

    public void getValue(ActionEvent event) {
        labelDateSc2.setText(choiceBoxSc2.getValue());
    }

    public void selectItem() {
        TreeItem<String> item = treeViewSc2.getSelectionModel().getSelectedItem();
        if (item != null) {
            System.out.println(item.getValue());
        }
    }
}
