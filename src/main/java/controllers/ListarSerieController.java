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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Escola;
import model.Serie;

public class ListarSerieController implements Initializable {

    @FXML
    TableView<Serie> tableViewSeries;
    @FXML
    TableColumn<Serie, String> colunaNome;
    @FXML
    TableColumn<Serie, Integer> colunaID;
    @FXML
    TextField textFildIdEscola;
    @FXML
    TextField textFildIdSerie;
    @FXML
    Button buttonBuscar;
    private Alert alert;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        alert = new Alert(Alert.AlertType.INFORMATION);
    }

    public void buscar() {
        if (textFildIdEscola.getText().trim().isEmpty()) {
            alert.setContentText("Verifique Se Algum Campo Está Vazio  e Tente Novamente.");
            alert.showAndWait();
        } else {
            try {
                int idEscola = Integer.parseInt(textFildIdEscola.getText());
                try {
                    ArrayList<Serie> aux = buscarEscolaId(App.escolas, idEscola);
                    ObservableList<Serie> dados = FXCollections.observableArrayList(aux);
                    tableViewSeries.setItems(dados);
                } catch (NullPointerException e) {
                    alert.setContentText("Série Ou Escola Não Encontrada.");
                    alert.showAndWait();
                }

            } catch (NumberFormatException e) {
                alert.setContentText("O ID Não Pode Conter Letras.");
                alert.showAndWait();
            }
        }
    }

    public ArrayList<Serie> buscarEscolaId(ArrayList<Escola> lista, int idEscola) {
        for (Escola escola : lista) {
            if (escola.getId() == idEscola) {
                return escola.getSeries();
            }
        }
        return null;
    }
}
