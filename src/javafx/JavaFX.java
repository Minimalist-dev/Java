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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.SVGPath;
import javafxml.DesarrollosController;
import javafxml.NivelesController;

/**
 *
 * @author neury-dev
 */
public class JavaFX extends Application {
//    Scene scene = new Scene(borderPane, 1000, 500, Color.TRANSPARENT);
    public static BorderPane borderPane = new BorderPane();
    public HBox top                     = new HBox();
    public VBox left                    = new VBox();
    public StackPane center             = new StackPane();
    public VBox right                   = new VBox();
    public HBox bottom                  = new HBox();
    
    public int widthSide = 125;//WIDHT_SIDE 250
    public int heightSide = 125; //HEIGHT_SIDE 460
    
    
    public NivelesController niveles = new NivelesController();
    
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
//        Scene scene = new Scene(borderPane, 1000, 500, Color.TRANSPARENT);
        Scene scene = new Scene(borderPane, 1000, 500);

        stage.setScene(scene);

        scene.getStylesheets().add("/i/css/root.css");
        scene.getStylesheets().add("/i/css/border_pane.css");
        scene.getStylesheets().add("/i/css/bottom.css");
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
//                //however we want to close only this instance of stage
//                stage.close();
            }
        });
        
        top.setPrefSize(widthSide, heightSide);
        top.setAlignment(Pos.CENTER);
//        top.setStyle("-fx-border-color: black;");
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
        
        SVGPath svgDesarrollo = new SVGPath();
        svgDesarrollo.setContent("M19,3h-4.18C14.4,1.84,13.3,1,12,1S9.6,1.84,9.18,3H5C4.86,3,4.73,3.01,4.6,3.04C4.21,3.12,3.86,3.32,3.59,3.59 c-0.18,0.18-0.33,0.4-0.43,0.64C3.06,4.46,3,4.72,3,5v14c0,0.27,0.06,0.54,0.16,0.78c0.1,0.24,0.25,0.45,0.43,0.64 c0.27,0.27,0.62,0.47,1.01,0.55C4.73,20.99,4.86,21,5,21h14c1.1,0,2-0.9,2-2V5C21,3.9,20.1,3,19,3z M11,14.17l-1.41,1.42L6,12 l3.59-3.59L11,9.83L8.83,12L11,14.17z M12,4.25c-0.41,0-0.75-0.34-0.75-0.75S11.59,2.75,12,2.75s0.75,0.34,0.75,0.75 S12.41,4.25,12,4.25z M14.41,15.59L13,14.17L15.17,12L13,9.83l1.41-1.42L18,12L14.41,15.59z");
        svgDesarrollo.getStyleClass().add("svg-path");
        
        SVGPath svgCodigo = new SVGPath();
        svgCodigo.setContent("M9.4 16.6L4.8 12l4.6-4.6L8 6l-6 6 6 6 1.4-1.4zm5.2 0l4.6-4.6-4.6-4.6L16 6l6 6-6 6-1.4-1.4z");
        svgCodigo.getStyleClass().add("svg-path");
        
        desarrollos.setGraphic(svgDesarrollo);
        codigo.setGraphic(svgCodigo);
        
        desarrollos.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent eventObject) {
                if(desarrollos.isSelected()) {
                    borderPane.getChildren().removeAll(borderPane.getLeft());
                        
                    DesarrollosController devs = new DesarrollosController();
                    devs.desarrollos();
                } else {
                    try {
                        Parent left = FXMLLoader.load(getClass().getResource("/javafxml/left.fxml"));
                        Parent niveles = FXMLLoader.load(getClass().getResource("/javafxml/niveles.fxml"));
                        
                        borderPane.setLeft(left);
                        borderPane.setCenter(niveles);
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
                        borderPane.setCenter(codigo);
                    } catch (IOException ex) {
                        Logger.getLogger(JavaFX.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        Parent left = FXMLLoader.load(getClass().getResource("/javafxml/left.fxml"));
                        Parent niveles = FXMLLoader.load(getClass().getResource("/javafxml/niveles.fxml"));
                        
                        borderPane.setLeft(left);
                        borderPane.setCenter(niveles);
                    } catch (IOException ex) {
                        Logger.getLogger(JavaFX.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        right.getStylesheets().add("/i/css/right.css");
        right.getStyleClass().add("v-box");
        right.getChildren().addAll(desarrollos, codigo);
        
        return right;
    }
    public HBox 
    agregarHBoxBottom() {
        Bottom footer = new Bottom();
        
//        borderPane.setBottom(footer.bottom());
        
        footer.bottom();
        
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
