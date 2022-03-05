package javafx.dev;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javafx.JavaFX;
import static javafx.JavaFX.borderPane;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Encriptado extends JavaFX {
    private TextField req   = new TextField("Encriptado");
    private Label res       = new Label("");
    
    
    public StackPane 
    doc() {
        final String[] string = new String[] {
            "texto", "numero"
        };
        
        ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList(
            "Texto", "Numero"
        ));
        
        choiceBox.getSelectionModel().selectedIndexProperty().addListener(
            (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
                if(string[new_val.intValue()] == "texto") {
                    res.setText("");
                    
                    if(Expresiones.Expresion.texto(req.getText())) {
                        res.setText("Coincide");
                    } else {
                        res.setText("No coincide");
                    }
                } else if(string[new_val.intValue()] == "numero") {
                    res.setText("");
                    
                    if(Expresiones.Expresion.numero(req.getText())) {
                        res.setText("Coincide");
                    } else {
                        res.setText("No coincide");
                    }
                } 
        });
        
        GridPane grid = new GridPane();
        
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        GridPane.setConstraints(res, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(req, 0, 1, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(choiceBox, 0, 2, 1, 1, HPos.CENTER, VPos.CENTER);

        grid.getStylesheets().add("/i/css/dev/expresiones.css");
        grid.getStyleClass().add("grid-pane");
        res.setAlignment(Pos.CENTER);

        grid.getChildren().addAll(
            res, 
            req, 
            choiceBox
        );
        borderPane.setCenter(grid);
        
        return center;
    }
    
    static class CriptoDoc {
    /* Retorna un hash a partir de un tipo y un texto */
    public static String 
    getHash(String txt, String hashType) {
        try {
            MessageDigest md    = MessageDigest.getInstance(hashType);
            byte[] array        = md.digest(txt.getBytes());
            StringBuffer sb     = new StringBuffer();
            
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    public static String 
    md5(String txt) {
        return CriptoDoc.getHash(txt, "MD5");
    }
    public static String 
    sha1(String txt) {
        return CriptoDoc.getHash(txt, "SHA-1");
    }
    public static String 
    sha256(String txt) {
        return CriptoDoc.getHash(txt, "SHA-256");
    }
    
    
    /* 1 */
    private SecretKeySpec 
    crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] claveEncriptacion = clave.getBytes("UTF-8");
         
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
         
        claveEncriptacion = sha.digest(claveEncriptacion);
        claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);
         
        SecretKeySpec secretKey = new SecretKeySpec(claveEncriptacion, "AES");
 
        return secretKey;
    }
 
    /**
     * Aplica la encriptacion AES a la cadena de texto usando la clave indicada
     * @param datos Cadena a encriptar
     * @param claveSecreta Clave para encriptar
     * @return Información encriptada
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public String 
    encriptar(String datos, String claveSecreta) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = this.crearClave(claveSecreta);
         
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");        
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
 
        byte[] datosEncriptar = datos.getBytes("UTF-8");
        byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
        String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);
 
        return encriptado;
    }
 
    /**
     * Desencripta la cadena de texto indicada usando la clave de encriptacion
     * @param datosEncriptados Datos encriptados
     * @param claveSecreta Clave de encriptacion
     * @return Informacion desencriptada
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public String 
    desencriptar(String datosEncriptados, String claveSecreta) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = this.crearClave(claveSecreta);
 
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
         
        byte[] bytesEncriptados = Base64.getDecoder().decode(datosEncriptados);
        byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
        String datos = new String(datosDesencriptados);
         
        return datos;
    }
    
    /* 2 */
    public byte[] 
    cifra(String sinCifrar) throws Exception {
        final byte[] bytes = sinCifrar.getBytes("UTF-8");
        final Cipher aes = obtieneCipher(true);
        final byte[] cifrado = aes.doFinal(bytes);
        return cifrado;
    }

    public String 
    descifra(byte[] cifrado) throws Exception {
        final Cipher aes = obtieneCipher(false);
        final byte[] bytes = aes.doFinal(cifrado);
        final String sinCifrar = new String(bytes, "UTF-8");
        return sinCifrar;
    }

    private Cipher 
    obtieneCipher(boolean paraCifrar) throws Exception {
        final String frase = "FraseLargaConDiferentesLetrasNumerosYCaracteresEspeciales_áÁéÉíÍóÓúÚüÜñÑ1234567890!#%$&()=%_NO_USAR_ESTA_FRASE!_";
        final MessageDigest digest = MessageDigest.getInstance("SHA");
        digest.update(frase.getBytes("UTF-8"));
        final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

        final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        if (paraCifrar) {
            aes.init(Cipher.ENCRYPT_MODE, key);
        } else {
            aes.init(Cipher.DECRYPT_MODE, key);
        }

	return aes;
    }
}

}
