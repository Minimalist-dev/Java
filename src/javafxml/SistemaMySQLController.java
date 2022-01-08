/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author neury-dev
 */
public class SistemaMySQLController implements Initializable {

    @FXML
    private TextField entradaId;
    @FXML
    private TextField entradaTitulo;
    @FXML
    private TextField entradaAutor;
    @FXML
    private TextField entradaYear;
    @FXML
    private TextField entradaPagina;
    @FXML
    private TableView<Tabla> tabla;
    @FXML
    private TableColumn<Tabla, Integer> columnaId;
    @FXML
    private TableColumn<Tabla, String> columnaTitulo;
    @FXML
    private TableColumn<Tabla, String> columnaAutor;
    @FXML
    private TableColumn<Tabla, Integer> columnaYear;
    @FXML
    private TableColumn<Tabla, Integer> columnaPagina;
    @FXML
    private Button insertar;
    @FXML
    private Button actualizar;
    @FXML
    private Button eliminar;
    @FXML
    private Button limpiar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showTabla();
    }    
    @FXML public void 
    handle(ActionEvent event) {
        if(event.getSource() == insertar) {
            insertRecord();
        } else if(event.getSource() == actualizar) {
            updateRecord();
        } else if(event.getSource() == eliminar) {
            deleteRecord();
        } else if(event.getSource() == limpiar) {
            limpiar();
        }
        
        showTabla();
    }
    public Connection 
    getConnection() {
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
            return conn;
        } catch(Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        } 
    }
    public ObservableList<Tabla> 
    getTablaList() {
        ObservableList<Tabla> tablaList = FXCollections.observableArrayList();
        
        Connection conn = getConnection();
        String query    = "SELECT * FROM SistemaMySQL";
        Statement st;
        ResultSet rs;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
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
        String query = "INSERT INTO SistemaMySQL VALUES(" 
            + entradaId.getText() + ", '" 
            + entradaTitulo.getText() + "', '" 
            + entradaAutor.getText() + "', " 
            + entradaYear.getText() + ", " 
            + entradaPagina.getText() + ")";
        
        executeQuery(query);
    }
    private void 
    updateRecord() {
        String query = "UPDATE SistemaMySQL SET "
            + "titulo='" + entradaTitulo.getText() + "', "
            + "autor='" + entradaAutor.getText() + "', "
            + "year=" + entradaYear.getText() + ", "
            + "pagina=" +  entradaPagina.getText() + " WHERE id = " + entradaId.getText();
        
        executeQuery(query);
    }
    private void 
    deleteRecord() {
        String query = "DELETE FROM SistemaMySQL WHERE id = " + entradaId.getText();
        
        executeQuery(query);
    }
    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
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
}
