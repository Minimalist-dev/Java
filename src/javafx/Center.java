package javafx;

import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;

/**
 *
 * @author neury-dev
 */
public class Center extends JavaFX {
    public Pane pane = new Pane();

    public SVGPath path = new SVGPath();

    public Line lineaY = new Line();
    public Line lineaX = new Line();

    public Text dies    = new Text("10");
    public Text nueve   = new Text("9");
    public Text ocho    = new Text("8");
    public Text siete   = new Text("7");
    public Text seis    = new Text("6");
    public Text cinco   = new Text("5");
    public Text cuatro  = new Text("4");
    public Text tres    = new Text("3");
    public Text dos     = new Text("2");
    public Text uno     = new Text("1");
    public Text cero    = new Text("0");

    public Line linea10 = new Line();
    public Line linea9  = new Line();
    public Line linea8  = new Line();
    public Line linea7  = new Line();
    public Line linea6  = new Line();
    public Line linea5  = new Line();
    public Line linea4  = new Line();
    public Line linea3  = new Line();
    public Line linea2  = new Line();
    public Line linea1  = new Line();
    public Line linea0  = new Line();

    private static Circle circleHTML           = new Circle();
    private static Circle circleXML            = new Circle();
    private static Circle circleCSS            = new Circle();
    private static Circle circleJavaScript     = new Circle();
    private static Circle circleJava           = new Circle();
    private static Circle circlePHP            = new Circle();
    private static Circle circleSQL            = new Circle();
    private static Circle circleJSON           = new Circle();
    private static Circle circleARIA           = new Circle();
    private static Circle circleSVG            = new Circle();
    private static Circle circleApacheNetBeans = new Circle();
    private static Circle circleGitAndGitHub   = new Circle();
        
    public StackPane 
    niveles() {
        pane.getChildren().addAll(
            path, lineaY, lineaX, 
            cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, dies,
            linea10, linea9, linea8, linea7, linea6, linea5, linea4, linea3, linea2, linea1, linea0,
            circleHTML, circleXML, circleCSS, circleJavaScript, circleJava, circlePHP, circleSQL, circleJSON, circleARIA, 
            circleSVG, circleApacheNetBeans, circleGitAndGitHub
        );
        center.getChildren().add(pane);

        pane.getStylesheets().add("/i/css/niveles.css");
        pane.getStyleClass().add("niveles");

        pane.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
        pane.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
        
        path.setContent("M 0 350 l 100 -200 q 50 -100 100 0 q 50 100 100 0 l 100 -200");
        path.setStyle("-fx-stroke: white;-fx-fill: transparent;");
        path.setStrokeWidth(2);
        path.setLayoutX(46.0);
        path.setLayoutY(-2.0);
        path.setScaleY(0.64);
        
        lineaY.setStrokeWidth(2);
        lineaY.setStyle("-fx-stroke: white;");
        lineaY.setLayoutX(43.0);
        lineaY.setLayoutY(20.0);
        lineaY.setEndY(259.0);
        
        lineaX.setStrokeWidth(2);
        lineaX.setStyle("-fx-stroke: white;");
        lineaX.setLayoutX(43.0);
        lineaX.setLayoutY(279.0);
        lineaX.setEndX(402.0);
        
        dies.getStyleClass().add("text");
        nueve.getStyleClass().add("text");
        ocho.getStyleClass().add("text");
        siete.getStyleClass().add("text");
        seis.getStyleClass().add("text");
        cinco.getStyleClass().add("text");
        cuatro.getStyleClass().add("text");
        tres.getStyleClass().add("text");
        dos.getStyleClass().add("text");
        uno.getStyleClass().add("text");
        cero.getStyleClass().add("text");
        
        dies.setLayoutX(14.0);
        nueve.setLayoutX(22.0);
        ocho.setLayoutX(22.0);
        siete.setLayoutX(22.0);
        seis.setLayoutX(22.0);
        cinco.setLayoutX(22.0);
        cuatro.setLayoutX(22.0);
        tres.setLayoutX(22.0);
        dos.setLayoutX(22.0);
        uno.setLayoutX(22.0);
        cero.setLayoutX(22.0);
        
        dies.setLayoutY(20.0);
        nueve.setLayoutY(45.9);
        ocho.setLayoutY(71.8);
        siete.setLayoutY(97.7);
        seis.setLayoutY(123.6);
        cinco.setLayoutY(149.5);
        cuatro.setLayoutY(175.4);
        tres.setLayoutY(201.3);
        dos.setLayoutY(227.2);
        uno.setLayoutY(253.1);
        cero.setLayoutY(279.0);
        
        linea10.getStyleClass().add("line");
        linea9.getStyleClass().add("line");
        linea8.getStyleClass().add("line");
        linea7.getStyleClass().add("line");
        linea6.getStyleClass().add("line");
        linea5.getStyleClass().add("line");
        linea4.getStyleClass().add("line");
        linea3.getStyleClass().add("line");
        linea2.getStyleClass().add("line");
        linea1.getStyleClass().add("line");
        linea0.getStyleClass().add("line");
        
        linea10.setStartX(32.0);
        linea9.setStartX(32.0);
        linea8.setStartX(32.0);
        linea7.setStartX(32.0);
        linea6.setStartX(32.0);
        linea5.setStartX(32.0);
        linea4.setStartX(32.0);
        linea3.setStartX(32.0);
        linea2.setStartX(32.0);
        linea1.setStartX(32.0);
        linea0.setStartX(32.0);
        
        linea10.setStartX(32.0);
        linea9.setStartX(32.0);
        linea8.setStartX(32.0);
        linea7.setStartX(32.0);
        linea6.setStartX(32.0);
        linea5.setStartX(32.0);
        linea4.setStartX(32.0);
        linea3.setStartX(32.0);
        linea2.setStartX(32.0);
        linea1.setStartX(32.0);
        linea0.setStartX(32.0);
        
        linea10.setEndX(42.0);
        linea9.setEndX(42.0);
        linea8.setEndX(42.0);
        linea7.setEndX(42.0);
        linea6.setEndX(42.0);
        linea5.setEndX(42.0);
        linea4.setEndX(42.0);
        linea3.setEndX(42.0);
        linea2.setEndX(42.0);
        linea1.setEndX(42.0);
        linea0.setEndX(42.0);
        
        linea10.setLayoutY(20.0);
        linea9.setLayoutY(45.9);
        linea8.setLayoutY(71.8);
        linea7.setLayoutY(97.7);
        linea6.setLayoutY(123.6);
        linea5.setLayoutY(149.5);
        linea4.setLayoutY(175.4);
        linea3.setLayoutY(201.3);
        linea2.setLayoutY(227.2);
        linea1.setLayoutY(253.1);
        linea0.setLayoutY(279.0);
        
        circleHTML.getStyleClass().add("circle");
        circleXML.getStyleClass().add("circle");
        circleCSS.getStyleClass().add("circle");
        circleJavaScript.getStyleClass().add("circle");
        circleJava.getStyleClass().add("circle");
        circlePHP.getStyleClass().add("circle");
        circleSQL.getStyleClass().add("circle");
        circleJSON.getStyleClass().add("circle");
        circleARIA.getStyleClass().add("circle");
        circleSVG.getStyleClass().add("circle");
        circleApacheNetBeans.getStyleClass().add("circle");
        circleGitAndGitHub.getStyleClass().add("circle");
        
        circleHTML.setRadius(6);
        circleXML.setRadius(6);
        circleCSS.setRadius(6);
        circleJavaScript.setRadius(6);
        circleJava.setRadius(6);
        circlePHP.setRadius(6);
        circleSQL.setRadius(6);
        circleJSON.setRadius(6);
        circleARIA.setRadius(6);
        circleSVG.setRadius(6);
        circleApacheNetBeans.setRadius(6);
        circleGitAndGitHub.setRadius(6);
        
        circleHTML.setLayoutX(430.0);
        circleXML.setLayoutX(110.0);
        circleCSS.setLayoutX(422.0);
        circleJavaScript.setLayoutX(386.0);
        circleJava.setLayoutX(364.0);
        circlePHP.setLayoutX(375.0);
        circleSQL.setLayoutX(406.0);
        circleJSON.setLayoutX(396.0);
        circleARIA.setLayoutX(324.0);
        circleSVG.setLayoutX(414.0);
        circleApacheNetBeans.setLayoutX(152.0);
        circleGitAndGitHub.setLayoutX(130.0);
        
        circleHTML.setLayoutY(40.0);
        circleXML.setLayoutY(194.0);
        circleCSS.setLayoutY(50.0);
        circleJavaScript.setLayoutY(98.0);
        circleJava.setLayoutY(124.0);
        circlePHP.setLayoutY(111.0);
        circleSQL.setLayoutY(72.0);
        circleJSON.setLayoutY(84.0);
        circleARIA.setLayoutY(170.0);
        circleSVG.setLayoutY(62.0);
        circleApacheNetBeans.setLayoutY(140.0);
        circleGitAndGitHub.setLayoutY(168.0);
        
        circleHTML.setVisible(false);
        circleXML.setVisible(false);
        circleCSS.setVisible(false);
        circleJavaScript.setVisible(false);
        circleJava.setVisible(false);
        circlePHP.setVisible(false);
        circleSQL.setVisible(false);
        circleJSON.setVisible(false);
        circleARIA.setVisible(false);
        circleSVG.setVisible(false);
        circleApacheNetBeans.setVisible(false);
        circleGitAndGitHub.setVisible(false);
        
        return center;
    }
    public void 
    html() {
        ocultarNiveles();
        circleHTML.setVisible(true);
    }
    public void 
    xml() {
        ocultarNiveles();
        circleXML.setVisible(true);
    }
    public void
    ocultarNiveles() {
        circleHTML.setVisible(false);
        circleXML.setVisible(false);
        circleCSS.setVisible(false);
        circleJavaScript.setVisible(false);
        circleJava.setVisible(false);
        circlePHP.setVisible(false);
        circleSQL.setVisible(false);
        circleJSON.setVisible(false);
        circleARIA.setVisible(false);
        circleSVG.setVisible(false);
        circleApacheNetBeans.setVisible(false);
        circleGitAndGitHub.setVisible(false);
    }
}
