package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import model.Escola;
import model.Estabelecimento;
import model.Item;
import model.Serie;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Scene scene;
    public static Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;
    public static ArrayList<Escola> escolas;
    public static ArrayList<Estabelecimento> lojas;
    public static int idEscola = 0;
    public static int idSerie = 0;
    public static int idItem = 0;

    @Override
    public void start(Stage stage) throws NullPointerException {
        escolas = new ArrayList<>();
        lojas = new ArrayList<>();
        App.idEscola++;
        App.idItem++;
        App.idSerie++;
        Serie serie = new Serie("Primeiro", App.idSerie);
        serie.addItem(new Item("Caderno", 20.00, App.idItem));
        App.idItem++;
        serie.addItem(new Item("Lapis", 2.00, App.idItem));
        App.idItem++;
        serie.addItem(new Item("Caneta Azul", 5.00, App.idItem));
        Escola escola = new Escola("Menezes", App.idEscola);
        escola.adicionarSerie(serie);
        App.escolas.add(escola);
        Estabelecimento loja = new Estabelecimento("Loja 1");
        loja.addItem(new Item("Caderno", loja.getNome(), 22.0));
        Estabelecimento loja2 = new Estabelecimento("Loja 2");
        loja2.addItem(new Item("Caderno", loja2.getNome(), 15.0));
        App.lojas.add(loja);
        App.lojas.add(loja2);
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
            stage.setTitle("Buscar Material Escolar");
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
        //Service<UsuarioTeste> usuarioService = new Service<>(UsuarioTeste.class);//add
        launch(args);
    }                 
}
