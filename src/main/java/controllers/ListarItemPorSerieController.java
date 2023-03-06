/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import app.App;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Escola;
import model.Item;
import model.Serie;

/**
 * FXML Controller class
 *
 * @author Isabel
 */
public class ListarItemPorSerieController implements Initializable {

    @FXML
    TextField textFildIdEscola;
    @FXML
    TextField textFildIdSerie;
    @FXML
    TableView tableViewItens;
    @FXML
    TableColumn colunaNome;
    @FXML
    TableColumn colunaID;

    private Alert alert;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaID.setCellValueFactory(new PropertyValueFactory<>("preco"));
        alert = new Alert(Alert.AlertType.INFORMATION);
    }

    @FXML
    public void buscar() {
        if (textFildIdEscola.getText().trim().isEmpty() || textFildIdSerie.getText().trim().isEmpty()) {
            alert.setContentText("Verifique Se Algum Campo Está Vazio  e Tente Novamente.");
            alert.showAndWait();
        } else {
            try {
                int idEscola = Integer.parseInt(textFildIdEscola.getText());
                int idSerie = Integer.parseInt(textFildIdSerie.getText());
                try {
                    ArrayList<Item> aux = buscarEscolaId(App.escolas, idEscola, idSerie);
                    ObservableList<Item> dados = FXCollections.observableArrayList(aux);
                    tableViewItens.setItems(dados);

                } catch (NullPointerException e) {
                    alert.setContentText("Escola ou Série Não Encontrada.");
                    alert.showAndWait();
                }

            } catch (NumberFormatException e) {
                alert.setContentText("O ID Não Pode Conter Letras.");
                alert.showAndWait();
            }
        }

    }

    public ArrayList<Item> buscarEscolaId(ArrayList<Escola> lista, int idEscola, int idSerie) {
        for (Escola escola : lista) {
            if (escola.getId() == idEscola) {
                for (Serie serie : escola.getSeries()) {
                    if (serie.getId() == idSerie) {
                        return serie.getItens();
                    }
                }
            }
        }
        return null;
    }
}
