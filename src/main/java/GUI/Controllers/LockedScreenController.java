package GUI.Controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Martin Alejandro Melo
 * on 04/12/2016.
 */
public class LockedScreenController extends Controller {

    //Variables
    @FXML
    private ImageView imagen;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Image imagen = new Image(getClass().getClassLoader().getResource("images/locked.jpg").toURI().toString());
            this.imagen.setImage(imagen);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
