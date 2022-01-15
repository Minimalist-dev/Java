package z;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author neury-dev
 */
public class NivelesController implements Initializable {

    @FXML public AnchorPane demo;
    @FXML public Circle html;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public void nivel(StackPane stack) {
        try {
            Parent centro = FXMLLoader.load(getClass().getResource("niveles.fxml"));
            stack.getChildren().removeAll();
            stack.getChildren().setAll(centro);
        } catch (IOException ex) {
            Logger.getLogger(NivelesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void
    boton2(){
        System.out.println("SVG 2");

        demo.setVisible(false);
        html.setVisible(false);
        
//return demo;
    }
    public void
    boton(ActionEvent event) throws IOException {
        System.out.println("SVG");

        demo.setVisible(false);
        html.setVisible(false);
        
//return demo;
    }
}
