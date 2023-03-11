import javafx.application.Application;
import javafx.scene.*;
import javafx.util.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.input.*;
import javafx.scene.transform.*;
import javafx.stage.*;


public class App extends Application {
    private TextArea textArea;

    public void start(Stage primaryStage) {
        Circle circle = new Circle(50);
        textArea = new TextArea("this is some default text\n");
        VBox vBox = new VBox(10, circle, textArea);

        // circle
        circle.setFill(Color.CORAL);
        circle.setOnMouseClicked(new CircleClickedHandler());

        // vbox
        String vBoxStyle = "-fx-padding: 10;" + 
        "-fx-border-style: solid inside;" + 
        "-fx-border-width: 2;" + 
        "-fx-border-insets: 5;" + 
        "-fx-border-radius: 5;" + 
        "-fx-border-color: blue;";
        vBox.setStyle(vBoxStyle);

        // text area
        String textAreaStyle = "-fx-font: italic 20px monospace; -fx-text-fill: linear-gradient(to bottom right, red, black)";
        textArea.setStyle(textAreaStyle);

        Scene scene = new Scene(vBox, 200, 200);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setTitle("Title");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class CircleClickedHandler implements EventHandler<MouseEvent> {
        public void handle(MouseEvent e) {
            textArea.appendText("Mouse event handler has been called\n");
        }
    }
}
