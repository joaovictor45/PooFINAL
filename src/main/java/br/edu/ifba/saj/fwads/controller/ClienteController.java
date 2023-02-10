package br.edu.ifba.saj.fwads.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.ifba.saj.fwads.model.ClienteModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.Stage;


public class ClienteController {

    private ObservableList<ClienteModel> entities;
    private DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    
    @FXML
    private TableView<ClienteModel> tblClientes;
    @FXML
    private TableColumn<ClienteModel, Boolean> tclSelect;
    @FXML
    private TableColumn<ClienteModel, String> tclName;
    @FXML
    private TableColumn<ClienteModel, LocalDate> tclDtNascimento;
    @FXML
    private TableColumn<ClienteModel, String> tclRua;
    @FXML
    private TableColumn<ClienteModel, String> tclBairro;

    @FXML
    public void initialize() {
        tclSelect.setCellValueFactory(cellData -> cellData.getValue().selectedProperty()); 
        tclSelect.setCellFactory(CheckBoxTableCell.forTableColumn(tclSelect));
        tclName.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        tclDtNascimento.setCellFactory(column -> new TableCell<ClienteModel, LocalDate>() {
            @Override
            protected void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (empty) {
                    setText("");
                } else {
                    setText(dtFormatter.format(date));
                }
            }
        });
        tclDtNascimento.setCellValueFactory(cellData -> cellData.getValue().dtNascimentoProperty());
        tclRua.setCellValueFactory(cellData -> cellData.getValue().ruaProperty());
        tclBairro.setCellValueFactory(cellData -> cellData.getValue().bairroProperty());
        entities = entityList();
        tblClientes.setItems(entities); 

        //DatePickerCell
    }

    private ObservableList<ClienteModel> entityList() {  
        return FXCollections.observableArrayList(  
            new ClienteModel("Gabriel", LocalDate.now(), "Dias Gomes", "Cajueiro"),  
            new ClienteModel("Isabela", LocalDate.now(), "Dias Gomes", "Cajueiro")
        );  
    }

    protected ClienteFormController showFXMLFileModal(String resourceName) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceName));
            Scene scene = new Scene(loader.load(), 800, 600);            
            stage.setScene(scene);
            stage.show();
            return (ClienteFormController)loader.getController();            
        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Erro ao carregar o arquivo " + resourceName).showAndWait();
            e.printStackTrace();
        }
        return null;    
    }

    
    @FXML
    void entityAdd(ActionEvent event) {
        ClienteFormController clienteFormController = showFXMLFileModal("ClienteForm.fxml");
        if(clienteFormController!= null){
            clienteFormController.setCallBack(clienteModel -> entities.add(clienteModel));
        }        
    }

    @FXML
    void entityEdit(ActionEvent event) {
        ClienteFormController clienteFormController = showFXMLFileModal("ClienteForm.fxml");
        if(clienteFormController!= null){
            clienteFormController.setModel(tblClientes.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void entityRemove(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja excluir?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait()
        .filter(response -> response == ButtonType.YES)
        .ifPresent(response -> {
            tblClientes.getItems().removeAll(tblClientes.getItems().filtered(t -> t.isSelected()));
        });

    }


}
