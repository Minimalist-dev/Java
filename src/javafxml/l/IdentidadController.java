package javafxml.l;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.l.Identidad;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * FXML Controller class
 *
 * @author neury-dev
 */
public class IdentidadController implements Initializable {

    @FXML private ListView<?> listView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList observableList = FXCollections.observableArrayList();
        
        Label label = new Label("PC");
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
//        label.setStyle("-fx-text-fill: red;-fx-font-weight: bold;");
        observableList.addAll(
            label.getText() + ": " + Identidad.pc(),
            "Usuario: "     + Identidad.usuario(),
            "IP local: "    + Identidad.ipLocal(),
            "Idioma: "      + Identidad.idioma(),
            "Origen: "      + Identidad.origen(),
            "IPv4: "        + Identidad.ipv4(),
            "IPv6: "        + Identidad.ipv6(),
            "MACName: "     + Identidad.macName()
        );

        listView.setItems(observableList);
    }    
}
