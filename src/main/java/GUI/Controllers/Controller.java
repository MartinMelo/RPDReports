package GUI.Controllers;

import GUI.Scenes.Escena;
import Model.Usuario;
import javafx.fxml.Initializable;

/**
 * Created by Martin Alejandro Melo
 * on 04/12/2016.
 */
public abstract class Controller<E> implements Initializable {

    private Usuario usuario;
    private Escena<E> scene;


    //GETTERS && SETTERS
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Escena<E> getScene() {
        return scene;
    }

    public void setScene(Escena<E> scene) {
        this.scene = scene;
    }
}
