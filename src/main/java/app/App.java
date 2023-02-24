package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import model.UsuarioTeste;
import services.Service;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Scene scene;
    public static Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) throws NullPointerException {
        try {
            this.stage = stage;
            Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
            scene = new Scene(root);
            stage.initStyle(StageStyle.DECORATED.UNDECORATED);
            scene.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();

                }
            });

            scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffset); 
                    stage.setY(event.getScreenY() - yOffset);

                }
            });

            stage.setTitle("Vida e Oxigênio");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public static void setScene(Scene s) throws IOException {
        App.stage.setScene(s);
        App.stage.show();
        
    }
    public static void setRoot(Parent p, double width, double height) throws IOException {
       App.stage.setWidth(width);
       App.stage.setHeight(height);
       App.stage.centerOnScreen();
       App.scene.setRoot(p);
   }

    public static void main(String[] args) {
      Service<UsuarioTeste> usuarioService = new Service<>(UsuarioTeste.class);//add
      
       launch(args);
    }

}

