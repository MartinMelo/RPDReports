package GUI;

import GUI.Controllers.MainController;
import GUI.Scenes.MainScene;
import GUI.Utils.Loader;
import GUI.Utils.ScreenUtils;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.net.URISyntaxException;


/**
 * Created by Martin Alejandro
 * on 04/12/2016.
 */
public class MainWIndow  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = Loader.creaFxmlLoader("mainScene");
        Parent root = (Parent) fxmlLoader.load();
        Dimension dimension = ScreenUtils.screenSize();
        MainScene mainScene = new MainScene(root, dimension.width, dimension.height);
        MainController mainController = fxmlLoader.<MainController>getController();
        mainController.setScene(mainScene);
        mainController.crearTodasLasVentanas();
        /**
         * Cierra el programa.
         */
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing");
                System.exit(0);
            }
        });
        mainController.ponerVentanaDeBloqueo();
        primaryStage.setScene(mainScene);
        this.configurarVentanaPrincipal(primaryStage);
        primaryStage.show();
    }

    private void configurarVentanaPrincipal(Stage primaryStage) {
        primaryStage.setTitle("RPD Reports 2016");
        primaryStage.setMaximized(Boolean.TRUE);
        this.ponerIconoDeAplicacion(primaryStage);
    }

    /**
     * Pone el icono de la aplicacion.
     * @param primaryStage
     */
    private void ponerIconoDeAplicacion(Stage primaryStage) {
        try {
            Image applicationIcon = new Image(getClass().getClassLoader().getResource("images/logo.jpg").toURI().toString());
            primaryStage.getIcons().add(applicationIcon);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}