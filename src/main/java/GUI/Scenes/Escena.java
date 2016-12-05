package GUI.Scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by Martin Alejandro Melo
 * on 05/06/2015.
 */
public abstract class Escena<E> extends Scene {


    public Escena(Parent parent, double v, double v1) {
        super(parent, v, v1);
        this.cargarStyleCss();
    }

    protected abstract void cargarStyleCss();

    /**
     * Devuelve el stage de la aplicacion.
     * @return
     */
    public Stage getStage(){
        return (Stage)this.getWindow();
    }

    /**
     * Cambia la Scene al stage.
     * @param scene
     */
    public void cambiarScene(Scene scene){
        this.getStage().setScene(scene);
    }
}
