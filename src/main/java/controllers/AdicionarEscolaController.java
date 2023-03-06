/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import app.App;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import model.Escola;
import model.Item;
import model.Serie;

public class AdicionarEscolaController implements Initializable {

    @FXML
    TextField textFildNomeEscola;
    @FXML
    TextField textFildNomeSerie;
    @FXML
    TextField textFildNomeItem;
    @FXML
    TextField textFildValorItem;
    @FXML
    Button buttonAddSerie;
    @FXML
    Button buttonAddItem;
    @FXML
    Button buttonAddEscola;
    @FXML
    private ListView<String> tabelaSeries;
    Alert alert;

    @FXML
    private TableColumn<String, String> colunaNomeSerie;

    @FXML
    private ListView<String> tabelaItens;

    @FXML
    private TableColumn<String, String> colunaNomeItem;

    @FXML
    private TableColumn<String, Double> colunaValorItem;

    private ArrayList<Serie> series;
    private ArrayList<Item> itens;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.series = new ArrayList<>();
        itens = new ArrayList<>();
        alert = new Alert(Alert.AlertType.INFORMATION);
    }

    @FXML
    public void adicionarSerie() {
        if (textFildNomeSerie.getText().trim().isEmpty()) {
            alert.setContentText("Adicione Um Nome Para A Série Tente Novamente.");
            alert.showAndWait();
        } else if (this.itens.size() == 0) {
            alert.setContentText("Adicione Pelo Menos Um Item Tente Novamente.");
            alert.showAndWait();
        } else {
            String nomeSerie = textFildNomeSerie.getText();
            App.idSerie++;
            int id = App.idSerie;
            Serie serie = new Serie(textFildNomeSerie.getText(), id);
            serie.setItens(itens);
            this.series.add(serie);
            this.tabelaSeries.getItems().add(nomeSerie);
            alert.setContentText("Serie Adicionada");
            alert.showAndWait();
            textFildNomeSerie.setText("");
            textFildNomeItem.setText("");
            textFildValorItem.setText("");
            this.tabelaItens.getItems().clear();
        }
    }

    @FXML
    public void adicionarItem() {
        if (textFildNomeItem.getText().trim().isEmpty() || textFildValorItem.getText().trim().isEmpty()) {
            alert.setContentText("Verifique Se Algum Campo Está Vazio  e Tente Novamente.");
            alert.showAndWait();
        } else {
            try {
                Item item = new Item(textFildNomeItem.getText(), Double.parseDouble(textFildValorItem.getText()));
                App.idItem++;
                int id = App.idItem;
                itens.add(item);
                tabelaItens.getItems().addAll(item.getNome());
                alert.setContentText("Item Adicionado");
                alert.showAndWait();
                textFildNomeItem.setText("");
                textFildValorItem.setText("");
            } catch (NumberFormatException e) {
                alert.setContentText("O Campo Valor Não Pode Conter Letras.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void salvarEscola() {
        if (textFildNomeEscola.getText().trim().isEmpty()) {
            alert.setContentText("O Nome Da Escola Não Pode Estar Vazio");
            alert.showAndWait();
        } else if (this.series.size() == 0 || this.itens.size() == 0) {

            alert.setContentText("Adicione Pelo Menos Uma Série E Um Item Antes de Salvar");
            alert.showAndWait();
        } else {
            Escola escola = new Escola(textFildNomeEscola.getText(), series);
            App.idEscola++;
            int id = App.idEscola;
            escola.setId(id);
            App.escolas.add(escola);
            alert.setContentText("Escola Adicionada");
            alert.showAndWait();
            textFildNomeEscola.setText("");
            this.tabelaItens.getItems().clear();
            this.tabelaSeries.getItems().clear();
        }
    }
}
