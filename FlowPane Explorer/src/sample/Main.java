package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("FlowPane Explorer");

        // Create 4 Buttons to demonstrate FlowPane behaviour
        Button button1 = new Button("One");
        Button button2 = new Button("Two");
        Button button3 = new Button("Three");
        Button button4 = new Button("Four");

        // Create FlowPane as the root of our Scene Graph
        FlowPane root = new FlowPane();

        // Set gap between child nodes
        root.setHgap(10);
        root.setVgap(10);

        // Add Buttons to the FlowPane
        root.getChildren().addAll(button1, button2, button3, button4);

        // Set Alignment of child nodes in the FlowPane
        root.setAlignment(Pos.TOP_CENTER);

        // FlowPane can also layout child nodes vertically
        // root.setOrientation(Orientation.VERTICAL);

        // FlowPane has an alternate Constructor that allows us to specify the
        // Orientation, Hgap, Vgap and Child nodes when we create a new FlowPane Object.
        // Ths replaces the need for separate method calls after creating a new FlowPane.
        // FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, button1, button2, button3, button4);

        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
}
