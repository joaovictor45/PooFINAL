package br.edu.ifba.saj.fwads.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import br.edu.ifba.saj.fwads.controller.util.MenuController;

public class MasterController extends MenuController {


    @FXML
    private Button btnManu1;

    @FXML
    private Button btnManu2;


    @FXML
    private void showHome(ActionEvent event) {
        showFXMLFile("Home.fxml", (Button) event.getSource());
    }

    @FXML
    private void showCliente(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja exibir Cliente?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait()
                .filter(response -> response == ButtonType.YES)
                .ifPresent(response -> showFXMLFile("ClienteTable.fxml", (Button) event.getSource()));
    }

    @FXML
    public void initialize() {
        addButtonMenu(btnManu1);
        addButtonMenu(btnManu2);
        showFXMLFile("ClienteTable.fxml", null);
    }


}
