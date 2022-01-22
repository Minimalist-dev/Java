package javafxml.l;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.l.Paginacion;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sql.Usuario;

/**
 * FXML Controller class
 *
 * @author neury-dev
 */
public class SistemaMySQLController implements Initializable {
    
    @FXML private TextField entradaId;
    @FXML private TextField entradaTitulo;
    @FXML private TextField entradaAutor;
    @FXML private TextField entradaYear;
    @FXML private TextField entradaPagina;
    
    @FXML private TableView<Tabla> tabla;
    @FXML private TableColumn<Tabla, Integer> columnaId;
    @FXML private TableColumn<Tabla, String> columnaTitulo;
    @FXML private TableColumn<Tabla, String> columnaAutor;
    @FXML private TableColumn<Tabla, Integer> columnaYear;
    @FXML private TableColumn<Tabla, Integer> columnaPagina;
    
    @FXML private Button insertar;
    @FXML private Button actualizar;
    @FXML private Button eliminar;
    @FXML private Button limpiar;
    @FXML private Button anterior;
    @FXML private Button siguiente;
    
    public Paginacion pagination = new Paginacion();
    
//    public int page;
//    public int page2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showTabla();
        limite();
    }    
    @FXML public void 
    handle(ActionEvent event) {
        if(event.getSource() == insertar) {
            insertRecord(); showTabla();
        } else if(event.getSource() == actualizar) {
            updateRecord(); showTabla();
        } else if(event.getSource() == eliminar) {
            deleteRecord(); showTabla();
        } else if(event.getSource() == limpiar) {
            limpiar();
        } else if(event.getSource() == anterior) {
            anterior();
        } else if(event.getSource() == siguiente) {
            siguiente();
        }
    }
    public ObservableList<Tabla> 
    getTablaList() {
        ObservableList<Tabla> tablaList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM SistemaMySQL LIMIT 4";
        
        try {
            ResultSet rs = Usuario.getStatement().executeQuery(sql);
            
            Tabla tabla;
            
            while(rs.next()) {
                tabla = new Tabla(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("year"), rs.getInt("pagina"));
                tablaList.add(tabla);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return tablaList;
    } 
    public void 
    showTabla() {
        ObservableList<Tabla> list = getTablaList();
        
        columnaId.setCellValueFactory(new PropertyValueFactory<Tabla, Integer>("id"));
        columnaTitulo.setCellValueFactory(new PropertyValueFactory<Tabla, String>("titulo"));
        columnaAutor.setCellValueFactory(new PropertyValueFactory<Tabla, String>("autor"));
        columnaYear.setCellValueFactory(new PropertyValueFactory<Tabla, Integer>("Year"));
        columnaPagina.setCellValueFactory(new PropertyValueFactory<Tabla, Integer>("pagina"));
        
        tabla.setItems(list);
    }
    private void 
    insertRecord() {
        String sql = "INSERT INTO SistemaMySQL VALUES(" 
            + entradaId.getText() + ", '" 
            + entradaTitulo.getText() + "', '" 
            + entradaAutor.getText() + "', " 
            + entradaYear.getText() + ", " 
            + entradaPagina.getText() + ")";
        
        Usuario.executeUpdate(sql);
    }
    private void 
    updateRecord() {
        String sql = "UPDATE SistemaMySQL SET "
            + "titulo='" + entradaTitulo.getText() + "', "
            + "autor='" + entradaAutor.getText() + "', "
            + "year=" + entradaYear.getText() + ", "
            + "pagina=" +  entradaPagina.getText() + " WHERE id = " + entradaId.getText();
        
       Usuario.executeUpdate(sql);
    }
    private void 
    deleteRecord() {
        String sql = "DELETE FROM SistemaMySQL WHERE id = " + entradaId.getText();
        
        Usuario.executeUpdate(sql);
    }
    @FXML public void 
    handleTabla(MouseEvent event) {
        Tabla tab = tabla.getSelectionModel().getSelectedItem();
        
        entradaId.setText("" + tab.getId());
        entradaTitulo.setText("" + tab.getTitulo()); 
        entradaAutor.setText("" + tab.getAutor());
        entradaYear.setText("" + tab.getYear());
        entradaPagina.setText("" + tab.getPagina());
    }
    private void 
    limpiar() {
        entradaId.setText("");
        entradaTitulo.setText(""); 
        entradaAutor.setText("");
        entradaYear.setText("");
        entradaPagina.setText("");
    }

    
    
//    public int getPaso() {
//        return page2;
//    }
//    public void setPaso(int page2) {
//        this.page2 = page2;
//    }
//    public int itemsPerPage() {
//        return 4;
//    }
    public void 
    showTabla2(int pagina) { 
        ObservableList<Tabla> list = paginal(pagina);
        
        columnaId.setCellValueFactory(new PropertyValueFactory<Tabla, Integer>("id"));
        columnaTitulo.setCellValueFactory(new PropertyValueFactory<Tabla, String>("titulo"));
        columnaAutor.setCellValueFactory(new PropertyValueFactory<Tabla, String>("autor"));
        columnaYear.setCellValueFactory(new PropertyValueFactory<Tabla, Integer>("Year"));
        columnaPagina.setCellValueFactory(new PropertyValueFactory<Tabla, Integer>("pagina"));
        
        tabla.setItems(list);
    }
    public ObservableList<Tabla> 
    paginal(int pagina) {
        ObservableList<Tabla> tablaList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM SistemaMySQL LIMIT 4 OFFSET " + pagina;
        
        try {
            ResultSet rs = Usuario.getStatement().executeQuery(sql);
            
            Tabla tabla;
            
            while(rs.next()) {
                tabla = new Tabla(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("year"), rs.getInt("pagina"));
                tablaList.add(tabla);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return tablaList;
    }
    
    public void
    limite() {
        String sql = "SELECT COUNT(id) AS limite FROM SistemaMySQL";

        try {
            ResultSet rs = Usuario.getStatement().executeQuery(sql);
            
            while(rs.next()) {
                rs.getInt("limite");
                System.out.println("Res: " + rs.getInt("limite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SistemaMySQLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void 
    anterior() {
        showTabla2(pagination.anterior());
//        if(getPaso() > 0) {
//            page = (getPaso() - 1) * itemsPerPage();
//            setPaso(getPaso() - 1);
            
//            showTabla2(page);
//        }   
    }
    private void 
    siguiente() {
        showTabla2(pagination.siguiente());
//        if(getPaso() == 0) {
//            page = 1 * itemsPerPage();
//            setPaso(1);
//        } else {
//            page = (getPaso() + 1) * itemsPerPage();
//            setPaso(getPaso() + 1);
//        }
        
//        showTabla2(page);
    }
}
