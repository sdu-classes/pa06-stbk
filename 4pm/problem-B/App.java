import javafx.application.Application;
import javafx.scene.*;
import javafx.util.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.input.*;
import javafx.scene.transform.*;
import javafx.stage.*;


public class App extends Application {

    private VBox vBox;
    private TextArea textArea;
    private Circle circle;

    private Rectangle rectangle;
    private TextField textField;
    private HBox hBox;

    private RotateTransition rectangleRotateTransition;
    private ScaleTransition scaleTransition;

    public void start(Stage primaryStage) {

        // initialization
        circle = new Circle();
        textArea = new TextArea();
        vBox = new VBox();
        rectangle = new Rectangle();
        textField = new TextField();
        hBox = new HBox();
        rectangleRotateTransition = new RotateTransition();
        scaleTransition = new ScaleTransition();

        // circle
        circle.setRadius(50);
        circle.setFill(Color.CORAL);
        circle.setOnMouseClicked(e -> {
                textArea.appendText(String.format("Mouse event handler has been called at this location (%.2f, %.2f)\n", e.getX(), e.getY()));
            }
        );

        // vbox
        String vBoxStyle = "-fx-border-style: solid inside;" + 
        "-fx-border-width: 2;" + 
        "-fx-border-insets: 5;" + 
        "-fx-border-radius: 5;" + 
        "-fx-border-color: blue;";
        vBox.setStyle(vBoxStyle);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(hBox, textArea);

        // text area
        String textAreaStyle = "-fx-font: italic 20px monospace; -fx-text-fill: linear-gradient(to bottom right, red, black)";
        textArea.setStyle(textAreaStyle);

        // text field
        textField.setOnAction(e -> {
            String text = textField.getText();
            if (text.equals("start")) {
                rectangleRotateTransition.play();
                textField.clear();
            } else if (text.equals("pause")) {
                rectangleRotateTransition.pause();
                textField.clear();
            }
            // textArea.appendText(text + '\n');
        });
        textField.setOnKeyPressed(e -> {
            textArea.appendText(e.getCode().toString());
        });

        // rectangle
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setFill(Color.TAN);

        // hbox
        hBox.setSpacing(10);
        hBox.getChildren().addAll(circle, rectangle, textField);

        // rotate & scale transition
        rectangleRotateTransition.setDuration(Duration.millis(1000));
        rectangleRotateTransition.setNode(rectangle);
        rectangleRotateTransition.setAxis(new Point3D(0, 1, 0));
        rectangleRotateTransition.setByAngle(360);
        rectangleRotateTransition.setCycleCount(50);
        rectangleRotateTransition.setAutoReverse(false);
        scaleTransition.setDuration(Duration.millis(1000));
        scaleTransition.setNode(rectangle);
        scaleTransition.setByX(1.5);
        scaleTransition.setByY(1.5);
        scaleTransition.setCycleCount(50);
        scaleTransition.setAutoReverse(true);

        Scene scene = new Scene(vBox, 200, 200);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setTitle("Title");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
