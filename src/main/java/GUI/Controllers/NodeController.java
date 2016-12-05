package GUI.Controllers;

/**
 * Created by Martin Alejandro Melo
 * on 30/06/2015.
 */
public abstract class NodeController extends Controller {
    //Variables
    private MainMenuController parentController;

    //GETTERS && SETTERS

    public MainMenuController getParentController() {
        return parentController;
    }

    public void setParentController(MainMenuController parentController) {
        this.parentController = parentController;
    }
}
