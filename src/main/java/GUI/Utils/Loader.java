package GUI.Utils;

import javafx.fxml.FXMLLoader;

import java.awt.*;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Created by Martin Alejandro Melo
 * on 17/06/2015.
 */
public class Loader {

    public static FXMLLoader creaFxmlLoader(String nombre){
        Dimension dimension = ScreenUtils.screenSize();
        String path = "templates/big/"+nombre+".fxml";
        if(dimension.getWidth()<=1280 && dimension.getHeight()<=1024){
            path="templates/small/"+nombre+".fxml";
        }
        if(dimension.getWidth()<=1440 && dimension.getHeight()<=900){
            path="templates/medium/"+nombre+".fxml";
        }
        try{
            InputStream is = Loader.class.getClassLoader().getResourceAsStream(path);
            Path temp = Files.createTempFile("resource-", ".ext");
            Files.copy(is, temp, StandardCopyOption.REPLACE_EXISTING);
            return new FXMLLoader(temp.toUri().toURL());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getStylesheet(String nombre) {
        return Loader.class.getClassLoader().getResource("css/"+nombre+".css").toExternalForm();
    }
}
