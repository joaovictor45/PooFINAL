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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Estabelecimento;
import model.Item;

public class AdicionarLojaController implements Initializable {

    @FXML
    private TextField textFieldNomeLoja;
    @FXML
    private TextField textFieldNomeItem;
    @FXML
    private TextField textFieldValor;

    @FXML
    private ListView<String> listViewItens;
    private ArrayList<Item> itens;
    private Alert alert;

    @FXML
    public void adicionarItem() {

        if (textFieldNomeItem.getText().trim().isEmpty() || textFieldValor.getText().trim().isEmpty()) {
            alert.setContentText("Verifique Se Algum Campo Está Vazio  e Tente Novamente.");
            alert.showAndWait();
        } else {
            try {
                Item item = new Item(textFieldNomeItem.getText(), textFieldNomeLoja.getText(), Double.parseDouble(textFieldValor.getText()));
                itens.add(item);
                listViewItens.getItems().addAll(item.getNome());
                alert.setContentText("Item Adicionado");
                alert.showAndWait();
                textFieldNomeItem.setText("");
                textFieldValor.setText("");
            } catch (java.lang.NumberFormatException e) {
                alert.setContentText("O Campo Valor Não Pode Conter Letras.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void salvar() {
        if (this.itens.size() == 0) {
            alert.setContentText("Adicione Pelo Menos Um Item.");
            alert.showAndWait();
        } else {
            if (textFieldNomeLoja.getText().trim().isEmpty()) {
                alert.setContentText("Adicione O Nome Da Loja.");
                alert.showAndWait();
            } else {
                Estabelecimento loja = new Estabelecimento(textFieldNomeLoja.getText());
                loja.setItens(this.itens);
                App.lojas.add(loja);
                alert.setContentText("Loja Adicionada");
                alert.showAndWait();
                textFieldNomeLoja.setText("");
                listViewItens.getItems().clear();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        itens = new ArrayList<>();
        alert = new Alert(Alert.AlertType.INFORMATION);
    }
}
