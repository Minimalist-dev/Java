package javafx;

import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.SVGPath;

/**
 *
 * @author neury-dev
 */
public class Center extends JavaFX {
    public StackPane 
    niveles() {
        Pane pane       = new Pane();
        AnchorPane an   = new AnchorPane();
        SVGPath path    = new SVGPath();
        Line uno        = new Line();
        Line dos        = new Line();
        
        pane.setPrefWidth(449);
        pane.setPrefHeight(283);
        pane.setMinWidth(USE_COMPUTED_SIZE);
        pane.setMinHeight(USE_COMPUTED_SIZE);
        pane.setMaxWidth(USE_COMPUTED_SIZE);
        pane.setMaxHeight(USE_COMPUTED_SIZE);
        
        an.setPrefWidth(USE_COMPUTED_SIZE);
        an.setPrefHeight(USE_COMPUTED_SIZE);
        an.setMinWidth(USE_COMPUTED_SIZE);
        an.setMinHeight(USE_COMPUTED_SIZE);
        an.setMaxWidth(USE_COMPUTED_SIZE);
        an.setMaxHeight(USE_COMPUTED_SIZE);
        
        path.setContent("M 0 350 l 100 -200 q 50 -100 100 0 q 50 100 100 0 l 100 -200");
        path.setStyle("-fx-stroke: white;-fx-fill: transparent;");
        path.setStrokeWidth(2);
        path.setLayoutX(46.0);
        path.setLayoutY(-2.0);
        path.setScaleY(0.64);
        
        uno.setStrokeWidth(2);
        uno.setStyle("-fx-stroke: white;");
        uno.setLayoutX(43.0);
        uno.setLayoutY(20.0);
        uno.setEndY(259.0);
        
        dos.setStrokeWidth(2);
        dos.setStyle("-fx-stroke: white;");
        dos.setLayoutX(43.0);
        dos.setLayoutY(279.0);
        dos.setEndX(402.0);
        
//        an.getChildren().addAll(path, uno, dos);
//        pane.getChildren().addAll(an);

        pane.getChildren().addAll(path, uno, dos);
        center.getChildren().add(pane);
        
        pane.getStylesheets().add("/i/css/niveles.css");
        an.setId("anclar");
        pane.setId("niveles");
        pane.getStyleClass().add("niveles");
        
        
        return center;
    }
}
