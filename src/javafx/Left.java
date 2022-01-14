package javafx;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 *
 * @author neury-dev
 */
public class Left extends JavaFX {
    public VBox 
    izquierda() {
        VBox vbox = new VBox();
        
        Button html             = new Button("HTML");
        Button xml              = new Button("XML");
        Button css              = new Button("CSS");
        Button javascript       = new Button("JavaScript");
        Button java             = new Button("Java");
        Button php              = new Button("PHP");
        Button sql              = new Button("SQL");
        Button json             = new Button("JSON");
        Button aria             = new Button("ARIA");
        Button svg              = new Button("SVG");
        Button apacheNetBeans   = new Button("Apache NetBeans");
        Button gitAndGitHub     = new Button("Git y GitHub");
        
        vbox.getChildren().addAll(html, xml, css, javascript, java, php, sql, json, aria, svg, apacheNetBeans, gitAndGitHub);
        left.getChildren().add(vbox);
        vbox.setId("skills");
        
        return left;
    }
}
