package l;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.JavaFX;
import static javafx.JavaFX.borderPane;
import javafx.dev.CargarImg;
import javafx.dev.Expresiones;
import javafx.dev.Formulario;
import javafx.dev.Validador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class Desarrollos extends JavaFX {
    private static final int N      = 4;
    public static Hyperlink dev[]   = new Hyperlink[N];
    
    public void 
    devs() {
        ScrollPane scrollPane = new ScrollPane();
        
        FlowPane flowPane = new FlowPane();   
//        flowPane.setPadding(new Insets(0, 20, 0, 20));
//        flowPane.setPrefWrapLength(886); // preferred width allows for two columns
//        flowPane.setTranslateY(30);
        flowPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        
        AnchorPane anchorPane[] = new AnchorPane[N];

        Label dev2[] = new Label[N];
        
        String nombre[] = {
            "Formulario", 
            "Expresiones", 
            "Validador", 
            "Cargar imagen"
        };
        String fecha[] = {
            "05/02/2022 - 05/02/2022", 
            "05/02/2022 - 05/02/2022", 
            "05/02/2022 - 05/02/2022", 
            "12/02/2022 - 12/02/2022"
        };
        
        for (int i = 0; i < N; i++) {
            anchorPane[i] = new AnchorPane();
            anchorPane[i].setPrefSize(143, 32);
            anchorPane[i].getStyleClass().add("desarrollo");
            
            dev[i] = new  Hyperlink(nombre[i]);
            dev[i].setUnderline(false);
            dev2[i] = new  Label(fecha[i]);
            dev2[i].setLayoutY(10);
            
            
            anchorPane[i].getChildren().addAll(dev[i], dev2[i]);
            flowPane.getChildren().add(anchorPane[i]);
        }
        
        Ir ir = new Ir();
        ir.a();
        
        scrollPane.setContent(flowPane);
        borderPane.setCenter(scrollPane);
        
        flowPane.getStyleClass().add("flow-pane");
        scrollPane.getStylesheets().add("/i/css/dev/devs_fx.css");
    }
    
    static class Ir {
        public void 
        cargarDesarrollo(String pane) { 
            try {
                borderPane.setCenter(FXMLLoader.load(getClass().getResource(pane + ".fxml")));
            } catch (IOException ex) {
                Logger.getLogger(DesarrollosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public void 
        a() {
            dev[3].setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent eventObject) {
                    CargarImg cargarImg = new CargarImg();
                    cargarImg.cargarImg();
                }
            });
            dev[2].setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent eventObject) {
                    Validador validador = new Validador();
                    validador.deCampos();
                }
            });
            dev[1].setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent eventObject) {
                    Expresiones Expresiones = new Expresiones();
                    Expresiones.expresada();
                }
            });
            dev[0].setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent eventObject) {
                    Formulario formulario = new Formulario();
                    formulario.contacto();
                }
            });
        }
    }
}
