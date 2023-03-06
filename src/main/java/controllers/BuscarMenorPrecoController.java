package controllers;

import app.App;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
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
import model.Estabelecimento;
import model.Item;

public class BuscarMenorPrecoController implements Initializable {

    @FXML
    TextField textFieldNomeItem;
    @FXML
    TableView<Item> tableViewItensELoja;
    @FXML
    TableColumn<Item, String> colunaNome;
    @FXML
    TableColumn<Item, Double> colunaPreco;
    @FXML
    TableColumn<Item, String> colunaLoja;
    private ArrayList<Estabelecimento> lojas;
    Alert alert;

    @FXML
    public ArrayList<Item> buscar() {
        if (textFieldNomeItem.getText().trim().isEmpty()) {
            alert.setContentText("Você Deve Digitar O Nome Do Produto Para Realizar A Busca.");
            alert.showAndWait();
        } else {
            String chave = textFieldNomeItem.getText();
            ArrayList<Item> itens = new ArrayList<>();
            lojas = App.lojas;
            for (Estabelecimento loja : lojas) {
                for (Item item : loja.getItens()) {
                    if (item.getNome().trim().equalsIgnoreCase(chave.trim())) {
                        itens.add(item);
                    }
                }
            }
            if (itens.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Não Encontrado!");
                alert.showAndWait();
                this.textFieldNomeItem.setText("");
            } else {
                Comparator<Item> comparadorPreco = Comparator.comparingDouble(Item::getPreco);
                itens.sort(comparadorPreco); // Ordena a lista por preço
                ObservableList<Item> dados = FXCollections.observableArrayList(itens);
                tableViewItensELoja.setItems(dados);
                return itens;
            }
        }
        return null;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colunaLoja.setCellValueFactory(new PropertyValueFactory<>("loja"));
        this.lojas = new ArrayList<>();
        lojas = App.lojas;
    }
}
