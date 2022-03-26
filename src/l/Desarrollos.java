package l;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.JavaFX;
import static javafx.JavaFX.borderPane;
import javafx.dev.CargarImg;
import javafx.dev.EditorHTML;
import javafx.dev.Encriptado;
import javafx.dev.Expresiones;
import javafx.dev.Formulario;
import javafx.dev.IdentidadDeOS;
import javafx.dev.InvertirArray;
import javafx.dev.Validador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class Desarrollos extends JavaFX {
    private static final int N      = 8;
    private static Hyperlink dev[]   = new Hyperlink[N];

    public void 
    devs() {
        ScrollPane scrollPane = new ScrollPane();

        FlowPane flowPane = new FlowPane();
////        flowPane.setOrientation(Orientation.VERTICAL);
////        flowPane.setNodeOrientation(NodeOrientation.);
////        flowPane.setPadding(new Insets(0, 20, 0, 20));
////        flowPane.setPrefWrapLength(886); // preferred width allows for two columns
////        flowPane.setTranslateY(30);
//        
        AnchorPane anchorPane[] = new AnchorPane[N];

        Label dev2[] = new Label[N];
        
        String nombre[] = {
            "Formulario", 
            "Expresiones", 
            "Validador", 
            "Cargar imagen",
            "Encriptado",
            "Identidad de OS",
            "Editor HTML",
            "Invertir Array"
        };
        String fecha[] = {
            "05/02/2022 - 05/02/2022", 
            "05/02/2022 - 05/02/2022", 
            "05/02/2022 - 05/02/2022", 
            "12/02/2022 - 12/02/2022", 
            "05/03/2022 - 12/03/2022",
            "19/03/2022 - 19/03/2022",
            "19/03/2022 - 26/03/2022",
            "26/03/2022 - 26/03/2022"
        };
        
        int[] n = {7, 6, 5, 4, 3, 2, 1, 0};
        
        for (int i = 0; i < n.length; i++) {
            anchorPane[n[i]] = new AnchorPane();
            anchorPane[n[i]].setPrefSize(143, 32);
            anchorPane[n[i]].getStyleClass().add("desarrollo");
            
            dev[n[i]] = new  Hyperlink(nombre[n[i]]);
            dev[n[i]].setUnderline(false);
            dev2[n[i]] = new  Label(fecha[n[i]]);
            dev2[n[i]].setLayoutY(10);
            
            anchorPane[n[i]].getChildren().addAll(dev[n[i]], dev2[n[i]]);
            flowPane.getChildren().add(anchorPane[n[i]]);
        }
//        int[] n = { 0, 1, 2, 3, 4, 5, 6, 7 };
//        
//        for (int i = 0; i < n.length; i++) {
//            anchorPane[n[n.length -1 -i]] = new AnchorPane();
//            anchorPane[n[n.length -1 -i]].setPrefSize(143, 32);
//            anchorPane[n[n.length -1 -i]].getStyleClass().add("desarrollo");
//            
//            dev[n[n.length -1 -i]] = new  Hyperlink(nombre[n[n.length -1 -i]]);
//            dev[n[n.length -1 -i]].setUnderline(false);
//            dev2[n[n.length -1 -i]] = new  Label(fecha[n[n.length -1 -i]]);
//            dev2[n[n.length -1 -i]].setLayoutY(10);
//            
//            anchorPane[n[n.length -1 -i]].getChildren().addAll(dev[n[n.length -1 -i]], dev2[n[n.length -1 -i]]);
//            flowPane.getChildren().add(anchorPane[n[n.length -1 -i]]);
//        }
        
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
            dev[7].setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent eventObject) {
                    InvertirArray doc = new InvertirArray();
                    doc.doc();
                }
            });
            dev[6].setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent eventObject) {
                    EditorHTML editorHTML = new EditorHTML();
                    editorHTML.doc();
                }
            });
            dev[5].setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent eventObject) {
                    IdentidadDeOS identidadDeOS = new IdentidadDeOS();
                    identidadDeOS.doc();
                }
            });
            dev[4].setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent eventObject) {
                    Encriptado encriptado = new Encriptado();
                    encriptado.doc();
                }
            });
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
