package javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.i.Panel1;

/**
 *
 * @author neury-dev
 */
public class JavaFX {
    public static final Stage stage     = new Stage();
    public static BorderPane borderPane = new BorderPane();
    public HBox top                     = new HBox();
    public VBox left                    = new VBox();
    public StackPane centerObject       = new StackPane();
    public VBox right                   = new VBox();
    public HBox bottom                  = new HBox();
    
    public int widthSide = 125;//WIDHT_SIDE 250
    public int heightSide = 125; //HEIGHT_SIDE 460
    
    public void javaFX() {
//        final Stage stage = new Stage(StageStyle.TRANSPARENT);
        
        HBox topObject      = addHBoxTop();
        VBox leftObject     = addVBoxLeft();
        centerObject        = addStackPane();
        VBox rightObject    = addVBoxRight();
        HBox bottomObject   = addHBoxBottom();
        
//        topObject.toFront();
//        leftObject.toFront();
//        centerObject.toFront();
//        rightObject.toFront();
//        bottomObject.toFront();
        
        borderPane.setTop(topObject);
        borderPane.setLeft(leftObject);
        borderPane.setCenter(centerObject);
        borderPane.setRight(rightObject);
        borderPane.setBottom(bottomObject);
        
//        borderPane.setPrefSize(1000, 700);
        Scene sceneObject = new Scene(borderPane, 1000, 600, Color.TRANSPARENT);


        stage.setScene(sceneObject);
        stage.centerOnScreen();
        stage.show();
    }
    
    public HBox 
    addHBoxTop() {
        Button boton = new Button();
        boton.setText("Say 'Hello World'");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                //in case we would like to close whole demo
//                javafx.application.Platform.exit();
//
//                //however we want to close only this instance of stage
                stage.close();
            }
        });
        
        
        top.setPrefSize(widthSide, heightSide);
        top.setAlignment(Pos.CENTER);
        top.setStyle("-fx-border-color: black;");
        top.getChildren().addAll(boton);
        return top;
    } 
    public VBox
    addVBoxLeft() {
        Button boton = new Button();
        boton.setText("Say 'Hello World'");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                //in case we would like to close whole demo
//                javafx.application.Platform.exit();
//
//                //however we want to close only this instance of stage
                stage.close();
            }
        });
        
        
        left.setPrefSize(widthSide, heightSide);
        left.setAlignment(Pos.CENTER);
        left.setStyle("-fx-border-color: black;");
        left.getChildren().addAll(boton);
        return left;
    }
    public StackPane 
    addStackPane() {
        Panel1 panel1 = new Panel1();
                
        centerObject.getChildren().removeAll();
        centerObject.getChildren().add(panel1.panel1());
        
        return centerObject;
    }
    public VBox
    addVBoxRight() {
        Button boton = new Button();
        boton.setText("Say 'Hello World'");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Panel1 panel1 = new Panel1();
                
                centerObject.getChildren().removeAll();
                centerObject.getChildren().add(panel1.panel1());
                System.out.println("Hello World! 0");
            }
        });
        
        right.setPrefSize(widthSide, heightSide);
        right.setAlignment(Pos.CENTER);
        right.setStyle("-fx-border-color: black;");
        right.getChildren().addAll(boton);
        
        return right;
    }
    public HBox 
    addHBoxBottom() {
        Button boton = new Button();
        boton.setText("Say 'Hello World'");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                //in case we would like to close whole demo
//                javafx.application.Platform.exit();
//
//                //however we want to close only this instance of stage
                stage.close();
            }
        });
        
        
        bottom.setPrefSize(widthSide, heightSide);
        bottom.setAlignment(Pos.CENTER);
        bottom.setStyle("-fx-border-color: black;");
        bottom.getChildren().addAll(boton);

        return bottom;
    }
}
