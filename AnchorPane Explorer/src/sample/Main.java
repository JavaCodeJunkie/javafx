package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("AnchorPane Explorer");

        AnchorPane root = new AnchorPane();

        // Create Controls
        TextArea textArea = new TextArea();
        Button button1 = new Button("Open");
        button1.setPrefWidth(75.0);
        Button button2 = new Button("Close");
        button2.setPrefWidth(75.0);

        AnchorPane.setTopAnchor(textArea, 10.0);
        AnchorPane.setLeftAnchor(textArea, 10.0);
        AnchorPane.setRightAnchor(textArea, 100.0);
        AnchorPane.setBottomAnchor(textArea, 10.0);

        AnchorPane.setTopAnchor(button1, 10.0);
        AnchorPane.setRightAnchor(button1, 10.0);
        
        AnchorPane.setRightAnchor(button2, 10.0);
        AnchorPane.setBottomAnchor(button2, 10.0);

        root.getChildren().addAll(textArea, button1, button2);

        Scene scene = new Scene(root, 450, 250, Color.LIMEGREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
