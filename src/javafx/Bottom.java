package javafx;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.JavaFX.borderPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafxml.JavaFXMLController;

/**
 *
 * @author neury-dev
 */
public class Bottom extends JavaFX {
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
    public HBox 
    bottom() {
        Pane hbox = new Pane();
        hbox.setStyle("-fx-background-color: white;");
        hbox.setStyle("-fx-border-color: black;");
        
        Label desarrollo = new Label("Desarrollo de Neury");
        Label correo    = new Label("neury.developer@gmail.com");
        
        Button boton = new Button("Boton");
        
        correo.setText("neury.developer@gmail.com");
        
        desarrollo.setStyle("-fx-text-fill: white");
        correo.setStyle("-fx-text-fill: white");
        
        hbox.getChildren().addAll(desarrollo, boton, correo);
        
//        bottom.getChildren().add(hbox);
        
        borderPane.setBottom(hbox);
        
        return bottom;
    }
}
