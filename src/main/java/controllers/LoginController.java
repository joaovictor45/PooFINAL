package controllers;

import app.App;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Usuario;
import services.UsuarioDao;

public class LoginController implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private TextField lblUserEmail;
    @FXML
    private PasswordField lblPassword;
    @FXML
    private Button login;

    @FXML
    private void exit() {
        System.exit(0);

    }
    public static Stage stageCadastro;
    public static Scene sceneCadastro;

    @FXML
    public void autenticar(ActionEvent event) throws IOException {
        String email = lblUserEmail.getText();
        String senha = lblPassword.getText();
        Usuario usuario = new Usuario(email, senha);
        UsuarioDao usuarioDao = new UsuarioDao();
        boolean existe = usuarioDao.existeUsuario(usuario);

        Parent root = FXMLLoader.load(getClass().getResource("/view/telaPrincipal.fxml"));
        App.setRoot(root, 876, 735);
    }

    @FXML
    void cadastrar() throws IOException {

        stageCadastro = new Stage();
        stageCadastro.initStyle(StageStyle.UNDECORATED);
        //stageCadastro.setResizable(true);
        Parent root = FXMLLoader.load(getClass().getResource("/view/cadastroUsuario.fxml"));
        sceneCadastro = new Scene(root);
        stageCadastro.setScene(sceneCadastro);
        sceneCadastro.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();

            }
        });

        sceneCadastro.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stageCadastro.setX(event.getScreenX() - xOffset);
                stageCadastro.setY(event.getScreenY() - yOffset);

            }
        });
        stageCadastro.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }
}
