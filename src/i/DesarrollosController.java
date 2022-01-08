/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i;

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
import javafx.scene.layout.StackPane;
import javafxml.JavaFXMLController;

/**
 * FXML Controller class
 *
 * @author neury-dev
 */
public class DesarrollosController implements Initializable {
//    public JavaFXMLController javafxml = new JavaFXMLController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML public void 
    sistemaMySQL(ActionEvent event) {
//        javafxml..sistemaMySQL("/javafxml/sistemaMySQL");
        try {
            Parent centro = FXMLLoader.load(getClass().getResource("/javafxml/sistemaMySQL.fxml"));
//            center.getChildren().removeAll();
//            center.getChildren().setAll(centro);
//            javafxml.border.getChildren().removeAll(javafxml.border.getCenter());
//            javafxml.border.getChildren().setAll(centro);
//            javafxml.getCenter().getChildren().removeAll();
//            javafxml.getCenter().getChildren().setAll(centro);
        } catch (IOException ex) {
            Logger.getLogger(JavaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public StackPane
    stackPane(StackPane stack) {
        return stack;
    }
    public void 
    sistema(StackPane stack) {
        try {
            Parent centro = FXMLLoader.load(getClass().getResource("/javafxml/sistemaMySQL.fxml"));
            stack.getChildren().removeAll();
            stack.getChildren().setAll(centro);
        } catch (IOException ex) {
            Logger.getLogger(DesarrollosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
