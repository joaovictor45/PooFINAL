/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import model.Usuario;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Isabel
 */
public class CadastroUsuarioController implements Initializable {
 @FXML
    private TextField lblUserName;
    @FXML
    private PasswordField lblPassword;
    @FXML
    private TextField lblCPF;
    @FXML
    private TextField lblEmail;
    @FXML
    private Button buttonCadastrar;
    @FXML
    private Button buttonVoltarLogin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void realizarCadastro() throws SQLException {
        Alert aviso = new Alert(Alert.AlertType.INFORMATION);
        Usuario usuario = new Usuario();
        usuario.setNome(lblUserName.getText());
        usuario.setCpf(lblCPF.getText());
        usuario.setEmail(lblEmail.getText());
        usuario.setSenha(lblPassword.getText());
        //usuarioDao.insert(usuario);
        aviso.setTitle("Sucesso No Cadastro");
        aviso.setContentText("Cadastro Realizado Com Sucesso");
        aviso.showAndWait();

         
            aviso.setTitle("Dados inválidos");
            aviso.setContentText("Confira seus dados\nUm ou mais já cadastrados");
            aviso.showAndWait();
        
        LoginController.stageCadastro.close();

    } @FXML
    public void exit() {
        
        LoginController.stageCadastro.close();
    }}

   
    
