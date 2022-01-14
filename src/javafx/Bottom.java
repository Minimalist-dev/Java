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
import javafx.scene.layout.VBox;
import javafxml.JavaFXMLController;

/**
 *
 * @author neury-dev
 */
public class Bottom extends JavaFX {
    public HBox 
    bottom() {
        VBox hbox = new VBox();
        
        Label desarrollo    = new Label("Desarrollo de Neury");
        Label correo        = new Label("neury.developer@gmail.com");

        hbox.getChildren().addAll(desarrollo, correo);
        
        bottom.getChildren().add(hbox);
        
        hbox.getStyleClass().add("v-box");
        
        return bottom;
    }
}
