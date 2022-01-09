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
public class Panel1 extends JavaFX {
        public StackPane panel1() {
        Pane centerPane = new Pane();
        Button boton = new Button();
        boton.setText("Panel 1'");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Panel2 panel2 = new Panel2();
                System.out.println("Hello World! 1");
                
                centerObject.getChildren().removeAll();
                centerObject.getChildren().add(panel2.panel2());
            }
        });
        centerPane.getChildren().addAll(boton);
        centerObject.getChildren().add(
            centerPane
        );
        
        return centerObject;
    }
}
