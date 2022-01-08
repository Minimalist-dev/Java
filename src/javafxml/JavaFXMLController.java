package javafxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author neury-dev
 */
public class JavaFXMLController implements Initializable {
    
    @FXML private BorderPane border;
    @FXML public StackPane center;
    @FXML private ToggleButton desarrollos;
    @FXML private ToggleButton codigo;
    
    public NivelesController niveles = new NivelesController();
    
    @Override public void 
    initialize(URL url, ResourceBundle rb) {
        cargarLeft("left");
//        niveles.nivel(center);
        cargarCenter("niveles");   
    }
    private void 
    cargarLeft(String vbox) {
        try {
            Parent left = FXMLLoader.load(getClass().getResource(vbox + ".fxml"));
            border.getChildren().removeAll(border.getLeft());
            border.setLeft(left);
        } catch (IOException ex) {
            Logger.getLogger(JavaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void 
    cargarCenter(String pane) {
        try {
            Parent centro = FXMLLoader.load(getClass().getResource( pane + ".fxml"));
            center.getChildren().removeAll();
            center.getChildren().setAll(centro);
        } catch (IOException ex) {
            Logger.getLogger(JavaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML public void
    desarrollos(ActionEvent actionEvent) {
        if(desarrollos.isSelected()) {
            border.getChildren().removeAll(border.getLeft());
            cargarCenter("/i/desarrollos");
        } else {
            cargarLeft("left");
            cargarCenter("niveles"); 
        }
    }
    @FXML public void
    codigo(ActionEvent actionEvent) {
        if(codigo.isSelected()) {
            border.getChildren().removeAll(border.getLeft());
            cargarCenter("/i/code");
        } else {
            cargarLeft("left");
            cargarCenter("niveles"); 
        }
    }
}
