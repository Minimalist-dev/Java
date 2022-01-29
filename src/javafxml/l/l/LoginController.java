package javafxml.l.l;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafxml.l.DesarrollosController;
import sql.GetAndSet;

/**
 * FXML Controller class
 *
 * @author neury-dev
 */
public class LoginController implements Initializable {

    @FXML private Label usuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        usuario.setText(GetAndSet.getUsuario());
    }    

    @FXML public void 
    logout(ActionEvent event) {
        GetAndSet.setUsuario("");
        GetAndSet.setCodigo("");
        
        DesarrollosController dev = new DesarrollosController();
        dev.login();
    }
}
