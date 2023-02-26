package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;

public class TelaprincipalController implements Initializable {

    Alert alert;
    @FXML
    Pane paneMenuPrincipal;
    Pane paneAUX;

    @FXML
    public void exit() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alert = new Alert(Alert.AlertType.INFORMATION);

    }

    @FXML
    public void mudarParaAdicionarEscola() throws IOException {
        paneAUX = FXMLLoader.load(getClass().getResource("/view/adicionarEscola.fxml"));
        paneMenuPrincipal.getChildren().addAll(paneAUX);
        paneMenuPrincipal.setVisible(true);

    }

    @FXML
    public void mudarParaAdicionarSerie() throws IOException {
        paneAUX = FXMLLoader.load(getClass().getResource("/view/adicionarSerie.fxml"));
        paneMenuPrincipal.getChildren().addAll(paneAUX);
        paneMenuPrincipal.setVisible(true);

    }
//paneMenuPrincipal.getChildren().removeAll();

    @FXML
    public void mudarParaAdicionarItem() throws IOException {
        paneAUX = FXMLLoader.load(getClass().getResource("/view/adicionarItem.fxml"));
        paneMenuPrincipal.getChildren().addAll(paneAUX);
        paneMenuPrincipal.setVisible(true);

    }

    @FXML
    public void mudarParaAdicionarLoja() throws IOException {
        paneAUX = FXMLLoader.load(getClass().getResource("/view/adicionarLoja.fxml"));
        paneMenuPrincipal.getChildren().addAll(paneAUX);
        paneMenuPrincipal.setVisible(true);

    }

    @FXML
    public void mudarParaAdicionarPrecos() throws IOException {
        paneAUX = FXMLLoader.load(getClass().getResource("/view/adicionarPreco.fxml"));
        paneMenuPrincipal.getChildren().addAll(paneAUX);
        paneMenuPrincipal.setVisible(true);

    }

    @FXML
    public void mudarParaConsultarPrecos() throws IOException {
        paneAUX = FXMLLoader.load(getClass().getResource("/view/consultarPrecos.fxml"));
        paneMenuPrincipal.getChildren().addAll(paneAUX);
        paneMenuPrincipal.setVisible(true);

    }

    @FXML
    public void mudarParaBuscarMenorPreco() throws IOException {
        paneAUX = FXMLLoader.load(getClass().getResource("/view/buscarMenorPreco.fxml"));
        paneMenuPrincipal.getChildren().addAll(paneAUX);
        paneMenuPrincipal.setVisible(true);

    }

}
