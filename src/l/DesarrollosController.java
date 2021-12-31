package l;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author neury-dev
 */
public class DesarrollosController implements Initializable {
    
    @FXML
    private AnchorPane anchorPane;
    
    @Override
    public void 
    initialize(URL url, ResourceBundle rb) {
//        AnchorPane anchorPane = new AnchorPane();   
     
        
        Hyperlink idiomaObject[] = new Hyperlink[100];
        
        String nombreObject[] = {
            "afrikáans", "albanés", "alemán", "amhárico", "árabe", "armenio", "azerí", "bengalí", "bielorruso", "birmano",
            "bosnio", "búlgaro", "camboyano", "canarés", "catalán", "cebuano", "checo", "chichewa", "chino (simplificado)",
            "chino (tradicional)", "cingalés", "coreano", "corso", "criollo haitiano", "croata", "danés", "eslovaco",
            "esloveno", "español", "esperanto", "estonio", "euskera", "finlandés", "francés", "frisio", "gaélico escocés",
            "galés", "gallego", "georgiano", "griego", "gujarati", "hausa", "hawaiano", "hebreo", "hindi", "hmong", 
            "húngaro", "igbo", "indonesio", "ingles", "irlandés", "islandés", "italiano", "japonés", "javanés", "kazajo",
            "kirguís", "kurdo", "lao", "latín", "letón", "lituano", "luxemburgués", "macedonio", "malayalam", "malayo",
            "malgache", "maltés", "maorí", "maratí", "mongol", "neerlandés", "nepalí", "noruego", "panyabí", "pastún",
            "persa", "polaco", "portugués", "rumano", "ruso", "samoano", "serbio", "sesoto", "shona", "sindhi", "somalí",
            "suajili", "sueco", "sundanés", "tagalo", "tailandés", "tamil", "tayiko", "telugu", "turco", "ucraniano",
            "urdu", "uzbeco", "vietnamita", "xhosa", "yidis", "yoruba", "zulú"
        };
        
        for (int i = 0; i < 100; i++) {
            idiomaObject[i] = new  Hyperlink(nombreObject[i]);
            idiomaObject[i].setPrefWidth(140);
            idiomaObject[i].setUnderline(false);
//            idiomaObject[i].setId("n-idioma-hyperlink");
            anchorPane.getChildren().add(idiomaObject[i]);
        }
    }    
    
}
