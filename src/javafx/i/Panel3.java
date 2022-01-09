package javafx.i;

import javafx.JavaFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author neury-dev
 */
public class Panel3 extends JavaFX {
    public StackPane panel3() {
        Pane centerPane = new Pane();
        Button boton = new Button();
        boton.setText("Panel 3'");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Panel1 panel1 = new Panel1();
                System.out.println("Hello World! 3");
                
                centerObject.getChildren().removeAll();
                centerObject.getChildren().add(panel1.panel1());
            }
        });
        centerPane.getChildren().addAll(boton);
        centerObject.getChildren().add(
            centerPane
        );
        
        return centerObject;
    }
}
