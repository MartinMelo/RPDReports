package GUI.Controllers;

import GUI.Utils.Loader;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Martin Alejandro Melo
 * on 04/12/2016.
 */
public class MainController extends Controller {

    //Elementos de la UI.
    @FXML
    private Pane mainPane;
    //CONTROLLERS
    private LoginController loginController;
    //PANTALLAS
    private Node pantallaLogin;
    private Node pantallaBloqueada;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * Crea todas las ventanas que se van a utilizar en la aplicacion.
     */
    public void crearTodasLasVentanas() {
        this.crearVentanaDeLogin();
        this.crearVentanaDeBloqueo();
    }

    ///////////////CREACION DE TODAS LAS VENTANAS////////
    private void crearVentanaDeLogin(){
        try {
            this.cargarStyle("login");
            FXMLLoader fxmlLoader = Loader.creaFxmlLoader("login");
            Node panel = (Node) fxmlLoader.load();
            LoginController loginController = fxmlLoader.<LoginController>getController();
            loginController.setMainController(this);
            this.loginController = loginController;
            this.pantallaLogin = panel;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Crear ventana de bloqueo.
     */
    private void crearVentanaDeBloqueo(){
        try {
            FXMLLoader fxmlLoader = Loader.creaFxmlLoader("lockedScreen");
            Node panel = (Node) fxmlLoader.load();
            LockedScreenController lockedScreenController = fxmlLoader.<LockedScreenController>getController();
            this.pantallaBloqueada = panel;
            this.getScene().addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                public void handle(final KeyEvent keyEvent) {
                    if (keyEvent.getCode() == KeyCode.ENTER) {
                        MainController.this.ponerVentanaDeLogin();
                        keyEvent.consume();
                    }
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    ////////FIN DE CREACION DE TODAS LAS VENTANAS/////////
    /**
     * Carga el style para la ventana.
     * @param nombre
     */
    private void cargarStyle(String nombre) {
        this.getScene().getStylesheets().clear();
        this.getScene().getStylesheets().setAll(Loader.getStylesheet(nombre));
    }

    ///////PONER VENTANAS////////////
    public void ponerVentanaDeBloqueo() {
        this.settearVentanaCentral(this.pantallaBloqueada);
    }
    public void ponerVentanaDeLogin() {
        this.settearVentanaCentral(this.pantallaLogin);
    }
    ///////FIN PONER VENTANAS////////////
    /**
     * Cambia la pantalla principal de la aplicacion.
     * @param panel
     */
    private void settearVentanaCentral(Node panel) {
        this.mainPane.getChildren().clear();
        this.mainPane.getChildren().add(panel);
    }
}
