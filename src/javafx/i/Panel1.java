package javafx.i;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.JavaFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author neury-dev
 */
public class Panel1 extends JavaFX {
    public StackPane panel1() {
        Pane centerPane = new Pane();
        Button boton = new Button();
        boton.setText("Panel 1'");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    //                Panel2 panel2 = new Panel2();
                    System.out.println("Hello World! 1");
                    Parent centro = FXMLLoader.load(getClass().getResource("demo.fxml"));
                    centerPane.getChildren().removeAll();
                    centerPane.getChildren().add(centro);
                } catch (IOException ex) {
                    Logger.getLogger(Panel1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        centerPane.getChildren().addAll(boton);
        centerObject.getChildren().add(
            centerPane
        );
        
        return centerObject;
    }
}
