package javafx.i;

import javafx.JavaFX;
import static javafx.JavaFX.stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author neury-dev
 */
public class Panel2 extends JavaFX {
    
        public StackPane panel2() {
        Pane centerPane = new Pane();
        Button boton = new Button();
        boton.setText("Panel 2'");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Panel3 panel3 = new Panel3();
                
                centerObject.getChildren().removeAll();
                centerObject.getChildren().add(panel3.panel3());
                
                System.out.println("Hello World! 2");
            }
        });
        centerPane.getChildren().addAll(boton);
        centerObject.getChildren().add(
            centerPane
        );
        
        return centerObject;
    }
}

