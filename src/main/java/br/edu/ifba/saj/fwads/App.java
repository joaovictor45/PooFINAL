package br.edu.ifba.saj.fwads;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    
    private static Scene scene;
    private static FXMLLoader loader;

    @Override
    public void start(Stage stage) throws IOException {
        loader = new FXMLLoader(App.class.getResource("controller/Login.fxml"));
        scene = new Scene(loader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) {
        try {
            scene.setRoot(loadFXML(fxml));
        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Erro ao carregar o arquivo " + fxml).show();
            e.printStackTrace();
        }
    }

    private static Parent loadFXML(String fxml) throws Exception {
        loader = new FXMLLoader(App.class.getResource(fxml));
        return loader.load();
    }

    public static Object getController() {
        return loader.getController();
    }

    public static void main(String[] args) {
        
        //System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        launch();
    }

}