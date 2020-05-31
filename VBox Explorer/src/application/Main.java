package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("VBox Explorer");

		VBox vbox = new VBox();
		vbox.setAlignment(Pos.TOP_RIGHT);

		Button button1 = new Button("One");
		Button button2 = new Button("Two");
		Button button3 = new Button("Three");

		button1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		button2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		button3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		VBox.setVgrow(button1, Priority.ALWAYS);
		VBox.setVgrow(button2, Priority.ALWAYS);
		VBox.setVgrow(button3, Priority.ALWAYS);

		vbox.getChildren().addAll(button1, button2, button3);

		Scene scene = new Scene(vbox, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
