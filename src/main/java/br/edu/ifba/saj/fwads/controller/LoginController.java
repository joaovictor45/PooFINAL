package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.controller.auth.OAuthGoogleAuthenticator;
import br.edu.ifba.saj.fwads.controller.util.FormController;
import br.edu.ifba.saj.fwads.controller.validation.FromControllerValidationBuilder;
import br.edu.ifba.saj.fwads.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController extends FormController {

    @FXML
    private TextField txUsuario;

    @FXML
    private PasswordField txSenha;

    @FXML
    private Label lblEsqueceu;

    @FXML
    private Label lblGoogle;

    @FXML
    void entrar(ActionEvent event) {
        if (validate()) {
            App.setRoot("controller/Master.fxml");
            MasterController masterController = (MasterController) App.getController();
            User user = new User(null, txUsuario.getText(), App.class.getResource("controller/assets/google-icon-4.png").toString());
            masterController.setUser(user);
        }

    }

    @FXML
    void google(MouseEvent event) {
        OAuthGoogleAuthenticator authGoogle = new OAuthGoogleAuthenticator();
        User user = authGoogle.startLogin();
        if(user != null){
            App.setRoot("controller/Master.fxml");
            MasterController masterController = (MasterController) App.getController();
            masterController.setUser(user);
        }
    }

    @FXML
    public void initialize() {
        addValidation(FromControllerValidationBuilder.<TextField>builder()
                .control(txUsuario)
                .message("- Favor informar o usuario.")
                .resetConsumer(FromControllerValidationBuilder::resetTextField)
                .validationConsumer(FromControllerValidationBuilder::requiredTextField)
                .build());
        addValidation(FromControllerValidationBuilder.<PasswordField>builder().control(txSenha)
                .message("- Favor informar a senha.").build());

    }

}
