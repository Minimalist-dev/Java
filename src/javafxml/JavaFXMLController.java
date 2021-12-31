package javafxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author neury-dev
 */
public class JavaFXMLController implements Initializable {
    
    @FXML
    private StackPane center;
    @FXML
    private AnchorPane anchorPane;
//    @FXML
//    private void 
//    handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }
    @Override public void 
    initialize(URL url, ResourceBundle rb) {
        cargarCentro("niveles");
    }
    private void 
    cargarCentro(String pane) {
        try {
            Parent centro = FXMLLoader.load(getClass().getResource( pane + ".fxml"));
            center.getChildren().removeAll();
            center.getChildren().setAll(centro);
        } catch (IOException ex) {
            Logger.getLogger(JavaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void
    panel1(ActionEvent actionEvent) {
        cargarCentro("niveles");
    }
    public void
    panel2(ActionEvent actionEvent) {
        cargarCentro("Panel2");
    }
    public void
    panel3(ActionEvent actionEvent) {
        cargarCentro("Panel3");
    }
    public void
    desarrollos(ActionEvent actionEvent) {
        cargarCentro("/i/Desarrollos");
        
//        Hyperlink idiomaObject[] = new Hyperlink[100];
//        
//        String nombreObject[] = {
//            "afrikáans", "albanés", "alemán", "amhárico", "árabe", "armenio", "azerí", "bengalí", "bielorruso", "birmano",
//            "bosnio", "búlgaro", "camboyano", "canarés", "catalán", "cebuano", "checo", "chichewa", "chino (simplificado)",
//            "chino (tradicional)", "cingalés", "coreano", "corso", "criollo haitiano", "croata", "danés", "eslovaco",
//            "esloveno", "español", "esperanto", "estonio", "euskera", "finlandés", "francés", "frisio", "gaélico escocés",
//            "galés", "gallego", "georgiano", "griego", "gujarati", "hausa", "hawaiano", "hebreo", "hindi", "hmong", 
//            "húngaro", "igbo", "indonesio", "ingles", "irlandés", "islandés", "italiano", "japonés", "javanés", "kazajo",
//            "kirguís", "kurdo", "lao", "latín", "letón", "lituano", "luxemburgués", "macedonio", "malayalam", "malayo",
//            "malgache", "maltés", "maorí", "maratí", "mongol", "neerlandés", "nepalí", "noruego", "panyabí", "pastún",
//            "persa", "polaco", "portugués", "rumano", "ruso", "samoano", "serbio", "sesoto", "shona", "sindhi", "somalí",
//            "suajili", "sueco", "sundanés", "tagalo", "tailandés", "tamil", "tayiko", "telugu", "turco", "ucraniano",
//            "urdu", "uzbeco", "vietnamita", "xhosa", "yidis", "yoruba", "zulú"
//        };
//        
//        for (int i = 0; i < 100; i++) {
//            idiomaObject[i] = new  Hyperlink(nombreObject[i]);
//            idiomaObject[i].setPrefWidth(140);
//            idiomaObject[i].setUnderline(false);
////            idiomaObject[i].setId("n-idioma-hyperlink");
//            anchorPane.getChildren().add(idiomaObject[i]);
//        }
    }
}
