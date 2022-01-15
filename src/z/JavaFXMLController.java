package z;

import javafx.JavaFX;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.DefaultProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author neury-dev
 */
@DefaultProperty("center")
public class JavaFXMLController implements Initializable {
    
    @FXML public BorderPane border;
    @FXML public StackPane center;
//    @FXML private StackPane center;
    @FXML public ToggleButton desarrollos;
    @FXML public ToggleButton codigo;
    
    @Override public void 
    initialize(URL url, ResourceBundle rb) {
        cargarLeft("left");
//        niveles.nivel(center);
//        sistema.sistema(center);
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
    public void 
    cargarCenter(String pane) { 
        
        try {
            Parent centro = FXMLLoader.load(getClass().getResource( pane + ".fxml"));
  
            center.getChildren().removeAll();
            center.getChildren().setAll(centro);
        } catch (IOException ex) {
            Logger.getLogger(JavaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void cargar() {
        try {
            Parent centro = FXMLLoader.load(getClass().getResource("sistemaMySQL.fxml"));
  
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
            cargarCenter("desarrollos");
        } else {
            cargarLeft("left");
            cargarCenter("niveles"); 
        }
    }
    @FXML public void
    codigo(ActionEvent actionEvent) {
        JavaFX javafx = new JavaFX();
//        javafx.javaFX();
         if(codigo.isSelected()) {
//            javafx.javaFX();
        } else {
//            javafx.javaFX();
        }

//        if(codigo.isSelected()) {
//            border.getChildren().removeAll(border.getLeft());
//            cargarCenter("/i/code");
//        } else {
//            cargarLeft("left");
//            cargarCenter("niveles"); 
//        }
    }
    
}
