package javafxml.l;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.JavaFX;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author neury-dev
 */

public class DesarrollosController extends JavaFX implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    @Override public void 
    initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    public void 
    cargarDesarrollo(String pane) { 
        try {
            borderPane.setCenter(FXMLLoader.load(getClass().getResource(pane + ".fxml")));
//            Parent desarrollo = FXMLLoader.load(getClass().getResource(pane + ".fxml"));
//            borderPane.setCenter(desarrollo);
        } catch (IOException ex) {
            Logger.getLogger(DesarrollosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML 
    public StackPane 
    desarrollos() {
        cargarDesarrollo("/javafxml/desarrollos");
        return center;
    }
    @FXML public StackPane 
    sistemaMySQL() {
        cargarDesarrollo("/javafxml/dev/sistemaMySQL");
        return center;
    }

}
