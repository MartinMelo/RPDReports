package GUI.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Martin Alejandro Melo
 * on 05/06/2015.
 */
public class LoginController extends Controller {

    @FXML
    private TextField usuario;
    @FXML
    private PasswordField clave;
    @FXML
    private Button loginButton;
    @FXML
    private Label error;
    //El controller de la ventana principal
    private MainController mainController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.error.setText("");
    }

    public void vaciarClave() {
        this.clave.clear();
    }

    /**
     * Carga la info del usuario y cambia de scene.
     */
    @FXML
    private void loguearse(){
        this.error.setText("");
        if(realizarLogueo()){
            //this.mainController.socioLogueadoCorrectamente(this.getSocio());
        }else{
            this.informarClaveErronea();
        }
        Platform.runLater(() -> this.vaciarClave());
    }

    /**
     * Informar Clave Erronea.
     */
    private void informarClaveErronea() {
        this.vaciarClave();
        this.error.setText("Usuario o clave erronea");
    }

    private Boolean realizarLogueo(){
        //Long numero = new Long(LoginController.this.usuario.getText());
        //this.setSocio(this.terminalService.obtenerSocio(numero));
        //return this.getSocio().getClave().equals(this.clave.getText());
        return Boolean.TRUE;

    }
    //GETTERS && SETTERS
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
