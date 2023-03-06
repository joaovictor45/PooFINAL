package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

public class TelaprincipalController implements Initializable {

    @FXML
    Pane paneMenuPrincipal;

    @FXML
    public void exit() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void mudarParaAdicionarEscola() throws IOException {
        TrocarDeTelaPrincipal trocar = new TrocarDeTelaPrincipal(paneMenuPrincipal, "/view/adicionarEscola.fxml");
    }

    @FXML
    public void mudarParaAdicionarLoja() throws IOException {
        TrocarDeTelaPrincipal trocar = new TrocarDeTelaPrincipal(paneMenuPrincipal, "/view/adicionarLoja.fxml");
    }

    @FXML
    public void mudarParaAdicionarPrecos() throws IOException {
        TrocarDeTelaPrincipal trocar = new TrocarDeTelaPrincipal(paneMenuPrincipal, "/view/adicionarPreco.fxml");
    }

    @FXML
    public void mudarParaConsultarPrecos() throws IOException {
        TrocarDeTelaPrincipal trocar = new TrocarDeTelaPrincipal(paneMenuPrincipal, "/view/consultarPrecos.fxml");
    }

    @FXML
    public void mudarParaBuscarMenorPreco() throws IOException {
        TrocarDeTelaPrincipal trocar = new TrocarDeTelaPrincipal(paneMenuPrincipal, "/view/buscarMenorPreco.fxml");
    }

    @FXML
    void mudarParaListarEscolas() throws IOException {
        TrocarDeTelaPrincipal trocar = new TrocarDeTelaPrincipal(paneMenuPrincipal, "/view/listarEscolas.fxml");
    }

    @FXML
    void mudarParaListarSeries() throws IOException {
        TrocarDeTelaPrincipal trocar = new TrocarDeTelaPrincipal(paneMenuPrincipal, "/view/listarSerie.fxml");
    }

    @FXML
    public void mudarParaListarItemPorSerie() throws IOException {
        TrocarDeTelaPrincipal trocar = new TrocarDeTelaPrincipal(paneMenuPrincipal, "/view/listarItemPorSerie.fxml");
    }

}
