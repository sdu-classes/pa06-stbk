// register an event handler through anonymous class

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class MyProgram2 extends Application {

    private TextArea textArea;
    private Circle circle;
    private VBox vbox;

    public void start(Stage primaryStage) {
        
        // text area
        textArea = new TextArea();
        
        // circle
        circle = new Circle();
        circle.setCenterX(150);
        circle.setCenterY(150);
        circle.setRadius(50);
        circle.setFill(Color.CORAL);
        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                textArea.appendText("Mouse event handler has been called\n");
            }
        });

        // vbox
        vbox = new VBox(10, circle, textArea);
        String vBoxStyle = "-fx-padding: 10;" + 
        "-fx-border-style: solid inside;" + 
        "-fx-border-width: 2;" + 
        "-fx-border-insets: 5;" + 
        "-fx-border-radius: 5;" + 
        "-fx-border-color: blue;";
        vbox.setStyle(vBoxStyle);

        Scene scene = new Scene(vbox, 200, 200);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setTitle("Problem A");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
