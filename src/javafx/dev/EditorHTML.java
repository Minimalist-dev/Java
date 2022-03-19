package javafx.dev;

import javafx.JavaFX;
import static javafx.JavaFX.borderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/web/package-summary.html
public class EditorHTML extends JavaFX {
    private HTMLEditor htmlEditor = null;
    private final String INITIAL_TEXT = "<html><body>Lorem ipsum dolor sit amet, consectetur adipiscing elit."
            +"Nam tortor felis, pulvinar in scelerisque cursus, pulvinar at ante. Nulla consequat "
            + "congue lectus in sodales. Nullam eu est a felis ornare bibendum et nec tellus. "
            + "Vivamus non metus tempus augue auctor ornare. Duis pulvinar justo ac purus adipiscing "
            + "pulvinar. Integer congue faucibus dapibus. Integer id nisl ut elit aliquam sagittis "
            + "gravida eu dolor. Etiam sit amet ipsum sem.</body></html>";
    
    public StackPane 
    doc() {
        Group root = new Group();
//        primaryStage.setScene(new Scene(root));
        VBox vRoot = new VBox();

        vRoot.setPadding(new Insets(8, 8, 8, 8));
        vRoot.setSpacing(5);

        htmlEditor = new HTMLEditor();
        htmlEditor.setPrefSize(500, 245);
        htmlEditor.setHtmlText(INITIAL_TEXT);
        vRoot.getChildren().add(htmlEditor);

        final Label htmlLabel = new Label();
        htmlLabel.setMaxWidth(500);
        htmlLabel.setWrapText(true);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.getStyleClass().add("noborder-scroll-pane");
        scrollPane.setContent(htmlLabel);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(180);

        Button showHTMLButton = new Button("Show the HTML below");
        vRoot.setAlignment(Pos.CENTER);
        showHTMLButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                htmlLabel.setText(htmlEditor.getHtmlText());
            }
        });

        vRoot.getChildren().addAll(showHTMLButton, scrollPane);
        root.getChildren().addAll(vRoot);

        GridPane grid = new GridPane();
        
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        GridPane.setConstraints(root, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER);
//        GridPane.setConstraints(webView, 0, 1, 1, 1, HPos.CENTER, VPos.CENTER);
//        GridPane.setConstraints(choiceBox, 0, 2, 1, 1, HPos.CENTER, VPos.CENTER);

        grid.getStylesheets().add("/i/css/dev/identidad_de_os.css");
        grid.getStyleClass().add("grid-pane");

        grid.getChildren().addAll(
            root
        );
        borderPane.setCenter(grid);
        return center;
    }
}
