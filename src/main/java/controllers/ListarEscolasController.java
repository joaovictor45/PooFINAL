/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import app.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Escola;

public class ListarEscolasController implements Initializable {

    @FXML
    TableView<Escola> tableViewEscolas;
    @FXML
    TableColumn<Escola, String> colunaNome;
    @FXML
    TableColumn<Escola, Integer> colunaID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        ObservableList<Escola> dados = FXCollections.observableArrayList(App.escolas);
        tableViewEscolas.setItems(dados);
    }
}
