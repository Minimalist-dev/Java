package javafx.dev;

import l.fx.Img;
import javafx.JavaFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class CargarImg extends JavaFX {
    public static ImageView foto = new ImageView();
    public static Text text      = new Text();
    
    private static final int ANCHO = 200;
    
    public StackPane 
    cargarImg() {
        GridPane gridPane = new GridPane();
       
        gridPane.setHgap(10);
        gridPane.setVgap(10);
//        gridPane.setGridLinesVisible(true);
        Image image = new Image(getClass().getResourceAsStream("/i/img/dev/avatar.jpg"));

        foto.setImage(image);
        foto.setFitWidth(ANCHO);
        foto.setFitHeight(ANCHO);
        foto.setPreserveRatio(true);
        foto.setImage(image);
        foto.setSmooth(true);
        foto.setCache(true); 
        Rectangle clip = new Rectangle(ANCHO, ANCHO);
        clip.setArcWidth(ANCHO);
        clip.setArcHeight(ANCHO);
        foto.setClip(clip);
        GridPane.setConstraints(foto, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER);
        
        Button seleccionarImg = new Button("Seleccionar imagen");
        GridPane.setConstraints(seleccionarImg, 0, 1, 1, 1, HPos.CENTER, VPos.CENTER);
        seleccionarImg.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent eventObject) {
                if(seleccionarImg.equals(eventObject.getSource())) {
                    Img.seleccionar();
                }
            }
        });

        Img.guardar.setDisable(true);
        GridPane.setConstraints(Img.guardar, 0, 2, 1, 1, HPos.CENTER, VPos.CENTER);

        GridPane.setConstraints(text, 0, 3, 1, 1, HPos.CENTER, VPos.CENTER);
        
        gridPane.getChildren().addAll(
            foto, seleccionarImg, Img.guardar, text
        );
        
        gridPane.getStylesheets().add("/i/css/dev/cargar_img.css");
        gridPane.getStyleClass().add("grid-pane");
        
        borderPane.setCenter(gridPane);
        
        return center;
    } 
}
