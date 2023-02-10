package br.edu.ifba.saj.fwads.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

import br.edu.ifba.saj.fwads.controller.util.FormController;
import br.edu.ifba.saj.fwads.controller.validation.FromControllerValidationBuilder;
import br.edu.ifba.saj.fwads.model.ClienteModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class ClienteFormController extends FormController {

    private ClienteModel model;
    private Consumer<ClienteModel> callBack;

    @FXML
    private TextField txtNome;
    @FXML
    private DatePicker dtNascimento;
    @FXML
    private TextField txtRua;
    @FXML
    private TextField txtBairro;

    @FXML
    public void initialize() {
        model = new ClienteModel();
        bindEntity();

        dtNascimento.setConverter(
        new StringConverter<>() {
          final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

          @Override
          public String toString(LocalDate date) {
            return (date != null) ? dateFormatter.format(date) : "";
          }

          @Override
          public LocalDate fromString(String string) {
            return (string != null && !string.isEmpty())
                ? LocalDate.parse(string, dateFormatter)
                : null;
          }
        });

        addValidation(FromControllerValidationBuilder.<TextField>builder().control(txtNome).message("- Favor informar o Nome.").build());
        addValidation(FromControllerValidationBuilder.<DatePicker>builder().control(dtNascimento).message("- Favor informar a data de nascimento.").build());
        addValidation(FromControllerValidationBuilder.<TextField>builder().control(txtRua).message("- Favor informar a Rua.").build());
        addValidation(FromControllerValidationBuilder.<TextField>builder().control(txtBairro).message("- Favor informar o Bairro.").build());
    }

    private void bindEntity() {
        txtNome.textProperty().bindBidirectional(model.nomeProperty());
        dtNascimento.valueProperty().bindBidirectional(model.dtNascimentoProperty());
        txtRua.textProperty().bindBidirectional(model.ruaProperty());
        txtBairro.textProperty().bindBidirectional(model.bairroProperty());
    }

    @FXML
    void cancelar(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja cancelar?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait()
                .filter(response -> response == ButtonType.YES)
                .ifPresent(response -> {
                    Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                });
    }

    @FXML
    void salvar(ActionEvent event) {
        if(validate()){
            Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja salvar?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait()
            .filter(response -> response == ButtonType.YES)
            .ifPresent(response -> {
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
                if (callBack != null) {
                    callBack.accept(model);
                }
            });
        }
    }

    public void setCallBack(Consumer<ClienteModel> callBack) {
        this.callBack = callBack;
    }

    public void setModel(ClienteModel model) {
        this.model = model;
        if (model != null) {
            bindEntity();
        }
    }

}
