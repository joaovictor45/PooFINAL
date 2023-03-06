/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author Isabel
 */
public class TrocarDeTelaPrincipal {
    private Pane pane,aux;

    public TrocarDeTelaPrincipal(Pane pane,String location) throws IOException {
        this.aux = FXMLLoader.load(getClass().getResource(location));
        this.pane=pane;
        this.pane.getChildren().addAll(this.aux);
        this.pane.setVisible(true);
    }
}