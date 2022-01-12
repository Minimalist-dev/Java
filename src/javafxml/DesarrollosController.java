package javafxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.JavaFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.i.Panel1;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
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
            Parent desarrollo = FXMLLoader.load(getClass().getResource(pane + ".fxml"));
  
            borderPane.getChildren().removeAll(borderPane.getCenter());
            borderPane.setCenter(desarrollo);
        } catch (IOException ex) {
            Logger.getLogger(JavaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML public StackPane 
    desarrollos() {
        cargarDesarrollo("desarrollos");
        
        return center;
    }
    @FXML public StackPane 
    sistemaMySQL() {
        cargarDesarrollo("/javafxml/dev/sistemaMySQL");
        
        return center;
    }

}
