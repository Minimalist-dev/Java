/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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

public class DesarrollosController extends JavaFXMLController implements Initializable {
    
    @FXML
    public StackPane panel1() throws IOException {
        Parent centro = FXMLLoader.load(getClass().getResource("sistemaMySQL.fxml"));
        center.getChildren().removeAll();
        center.getChildren().add(centro);
        
        return center;
    }
     
    public DesarrollosController (){
        super();
//        loadFxml(DesarrollosController.class.getResource("/sistemaMySQL.fxml"), this);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    public void
    sistema() throws IOException {
//        Parent centro = FXMLLoader.load(getClass().getResource("JavaFXML.fxml"));
//        DesarrollosController contactosViewController = (DesarrollosController) centro.getController(); 
      
        loadFxml(DesarrollosController.class.getResource("/sistemaMySQL.fxml"), this);
//       de.center.getChildren().add(anclar);
    }
    @FXML public void
    sistema2(ActionEvent actionEvent) throws IOException {
        this.cargar();
//        JavaFXMLController fx = new JavaFXMLController();
//        StackPane s = fx.getCenter();
//        
//        Parent centro = FXMLLoader.load(getClass().getResource("sistemaMySQL.fxml"));
//        s.getChildren().removeAll();
//        s.getChildren().setAll(centro);
//        
//            System.out.println("Stack: " + centro);
//            de.center.getChildren().removeAll();
//            de.center.getChildren().setAll(centro);

//        System.out.println("Stack 1: " + fxmlURL);
    }
    
}
