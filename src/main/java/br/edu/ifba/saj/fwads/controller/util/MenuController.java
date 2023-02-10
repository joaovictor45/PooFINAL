package br.edu.ifba.saj.fwads.controller.util;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuController {


    private User user;


    @FXML
    private BorderPane masterPane;

    @FXML
    private Label userEmail;

    @FXML
    private Circle userPicture;

    private List<Button> menuItens;

    public MenuController(){
        menuItens = new ArrayList<>();
    }

    @FXML
    public void initialize() {
        final Circle clip = new Circle(25, 25, 25);
        userPicture.setClip(clip);
    }

    @FXML
    private void logOff() {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja realmente sair??", ButtonType.YES, ButtonType.NO);
        alert.showAndWait()
        .filter(response -> response == ButtonType.YES)
        .ifPresent(response -> {
            App.setRoot("controller/Login.fxml");
            setUser(null);
        });
    }

    protected void addButtonMenu(Button button){
        menuItens.add(button);
    }

    protected void showFXMLFile(String resourceName,  Button button) {
        try {
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource(resourceName));
            masterPane.setCenter(newLoadedPane);
            if (button != null) {
                setMenuItemSelected(button);
            }
        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Erro ao carregar o arquivo " + resourceName).showAndWait();
            e.printStackTrace();
        }
    }

    protected void setMenuItemSelected(Button button) {
        for (Button b : menuItens) {
            if (b.getStyleClass().contains("btn-menu-selected")) {
                if (button != b) {
                    b.getStyleClass().clear();
                    b.getStyleClass().add("btn-menu");
                }
            }
        }
        if (!button.getStyleClass().contains("btn-menu-selected")) {
            button.getStyleClass().clear();
            button.getStyleClass().add("btn-menu-selected");
        }
    }


    public void setUser(User user) {
        this.user = user;
        if(user != null){
            userEmail.setText(user.email());
            userPicture.setFill(new ImagePattern(new Image(user.picture())));
        }else{
            userEmail.setText("");
            userPicture.setFill(new ImagePattern(new Image(App.class.getResource("controller/assets/google-icon-4.png").toString())));
        }
    }

}
