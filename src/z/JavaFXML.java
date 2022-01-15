package z;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author neury-dev
 */
public class JavaFXML extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("JavaFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Doc. Java");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/i/img/logo.png")));
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    } 
}
