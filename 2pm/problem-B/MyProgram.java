// register an event handler through lambda expression

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.util.*;
import javafx.scene.*;
import javafx.animation.*;
import javafx.scene.input.*;
import javafx.scene.transform.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class MyProgram extends Application {

    private TextArea textArea;
    private Circle circle;
    private VBox vbox;

    private HBox hbox;
    private Rectangle rectangle;
    private TextField textField;
    private RotateTransition rt;

    public void start(Stage primaryStage) {

        // initialization
        textArea = new TextArea();
        circle = new Circle();
        vbox = new VBox(20);
        rectangle = new Rectangle(100, 100);
        textField = new TextField();
        hbox = new HBox(20);
        rt = new RotateTransition(Duration.millis(1000), rectangle);
        
        // text field
        textField.setOnKeyTyped(e -> {
            rt.play();
        });

        // circle
        circle.setRadius(50);
        circle.setFill(Color.CORAL);
        circle.setOnMouseClicked(e -> {
                String location = String.format("(%.2f, %.2f)", e.getX(), e.getY());
                textArea.appendText("Mouse event handler has been called at " + location + "\n");
            }
        );

        // vbox
        String vBoxStyle = "-fx-border-style: solid inside;" + 
        "-fx-border-width: 4;" + 
        "-fx-border-insets: 5;" + 
        "-fx-border-radius: 10;" + 
        "-fx-border-color: green;";
        vbox.setStyle(vBoxStyle);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(hbox, textArea);

        // rectangle
        rectangle.setFill(Color.TAN);
        
        // rotation transition
        rt.setAxis(Rotate.Y_AXIS);
        rt.setByAngle(360);
        rt.setCycleCount(400);
        rt.setAutoReverse(false);

        // hbox
        hbox.getChildren().addAll(circle, rectangle, textField);
        hbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 200, 200);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setTitle("Problem A");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
