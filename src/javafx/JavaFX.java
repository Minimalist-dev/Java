package javafx;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.i.Panel1;
import javafx.scene.Parent;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafxml.DesarrollosController;

/**
 *
 * @author neury-dev
 */
public class JavaFX extends Application{
    public static BorderPane borderPane = new BorderPane();
    public HBox top                     = new HBox();
    public VBox left                    = new VBox();
    public StackPane center             = new StackPane();
    public VBox right                   = new VBox();
    public HBox bottom                  = new HBox();
    
    public int widthSide = 125;//WIDHT_SIDE 250
    public int heightSide = 125; //HEIGHT_SIDE 460
    
    public void 
    init(Stage stage) {
        HBox topObject      = agregarHBoxTop();
        VBox leftObject     = agregarVBoxLeft();
        center        = agregarStackPane();
        VBox rightObject    = agregarVBoxRight();
        HBox bottomObject   = agregarHBoxBottom();
        
        borderPane.setTop(topObject);
        borderPane.setLeft(leftObject);
        borderPane.setCenter(center);
        borderPane.setRight(rightObject);
        borderPane.setBottom(bottomObject);
        borderPane.getStyleClass().add("border-pane");
        borderPane.getTop().getStyleClass().add("top");
        borderPane.getLeft().getStyleClass().add("left");
        borderPane.getCenter().getStyleClass().add("center");
        borderPane.getRight().getStyleClass().add("right");
        borderPane.getBottom().getStyleClass().add("bottom");
//        borderPane.setPrefSize(1000, 700);
        Scene scene = new Scene(borderPane, 1000, 500, Color.TRANSPARENT);

        stage.setScene(scene);
        
        scene.getStylesheets().add(JavaFX.class.getResource("/i/css/root.css").toExternalForm());
        scene.getStylesheets().add(JavaFX.class.getResource("/i/css/border_pane.css").toExternalForm());
//        scene.getStylesheets().add(JavaFX.class.getResource("css/left.css").toExternalForm());
//        scene.getStylesheets().add(JavaFX.class.getResource("css/center.css").toExternalForm());
//        scene.getStylesheets().add(JavaFX.class.getResource("css/right.css").toExternalForm());
//        scene.getStylesheets().add(JavaFX.class.getResource("css/bottom.css").toExternalForm());
//        scene.getStylesheets().add(JavaFX.class.getResource("css/sesion.css").toExternalForm());
    }
    
    public HBox 
    agregarHBoxTop() {
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
//                stage.close();
            }
        });
        
        
        top.setPrefSize(widthSide, heightSide);
        top.setAlignment(Pos.CENTER);
        top.setStyle("-fx-border-color: black;");
        top.getChildren().addAll(boton);
        return top;
    } 
    public VBox
    agregarVBoxLeft() {
        Parent lefta;
        try {
            lefta = FXMLLoader.load(getClass().getResource("/javafxml/left.fxml"));
            left.getChildren().addAll(lefta);
        } catch (IOException ex) {
            Logger.getLogger(JavaFX.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return left;
    }
    public StackPane 
    agregarStackPane() {
        try {
            Parent niveles = FXMLLoader.load(getClass().getResource("/javafxml/niveles.fxml"));
            center.getChildren().removeAll();
            center.getChildren().addAll(niveles);
        } catch (IOException ex) {
            Logger.getLogger(JavaFX.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return center;
    }
    public VBox
    agregarVBoxRight() {
        ToggleGroup grupo           = new ToggleGroup();
        ToggleButton desarrollos    = new ToggleButton("Desarrollos");
        ToggleButton codigo         = new ToggleButton("Codigo");
        
        desarrollos.setToggleGroup(grupo);
        codigo.setToggleGroup(grupo);
        
        desarrollos.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent eventObject) {
                if(desarrollos.isSelected()) {
                    borderPane.getChildren().removeAll(borderPane.getLeft());
//                    borderPane.getChildren().removeAll(borderPane.getCenter());
                        
                    DesarrollosController devs = new DesarrollosController();
//                        borderPane.setCenter(devs.panel1());
                    devs.desarrollos();
                } else {
                    try {
                        Parent left = FXMLLoader.load(getClass().getResource("/javafxml/left.fxml"));
                        borderPane.getChildren().removeAll(borderPane.getLeft());
                        borderPane.setLeft(left);
                        
                        Parent niveles = FXMLLoader.load(getClass().getResource("/javafxml/niveles.fxml"));
                        center.getChildren().removeAll();
                        center.getChildren().addAll(niveles);
                    } catch (IOException ex) {
                        Logger.getLogger(JavaFX.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        codigo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent eventObject) {
                if(codigo.isSelected()) {
                    try {
                        borderPane.getChildren().removeAll(borderPane.getLeft());
                        
                        Parent codigo = FXMLLoader.load(getClass().getResource("/i/code.fxml"));
                        center.getChildren().removeAll();
                        center.getChildren().addAll(codigo);
                    } catch (IOException ex) {
                        Logger.getLogger(JavaFX.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        Parent left = FXMLLoader.load(getClass().getResource("/javafxml/left.fxml"));
                        borderPane.getChildren().removeAll(borderPane.getLeft());
                        borderPane.setLeft(left);
                        
                        Parent niveles = FXMLLoader.load(getClass().getResource("/javafxml/niveles.fxml"));
                        center.getChildren().removeAll();
                        center.getChildren().addAll(niveles);
                    } catch (IOException ex) {
                        Logger.getLogger(JavaFX.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        right.getChildren().addAll(desarrollos, codigo);
        
        return right;
    }
    public HBox 
    agregarHBoxBottom() {
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
//                stage.close();
            }
        });
        
        
        bottom.setPrefSize(widthSide, heightSide);
        bottom.setAlignment(Pos.CENTER);
        bottom.setStyle("-fx-border-color: black;");
        bottom.getChildren().addAll(boton);

        return bottom;
    }
    @Override public void 
    start(Stage stage) throws Exception {
        init(stage);
        
        stage.setTitle("Doc. Java");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/i/img/logo.png")));
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.show();
    }
}
