package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		HBox hbox = new HBox();
		Button button1 = new Button("One");
		// button1.setPrefWidth(75);
		button1.setMaxWidth(Integer.MAX_VALUE);
		HBox.setMargin(button1, new Insets(10));
		HBox.setHgrow(button1, Priority.SOMETIMES);

		Button button2 = new Button("Two");
		// button2.setPrefWidth(75);
		button2.setMaxWidth(Integer.MAX_VALUE);
		HBox.setMargin(button2, new Insets(10));
		HBox.setHgrow(button2, Priority.SOMETIMES);

		Button button3 = new Button("Three");
		// button3.setPrefWidth(75);
		button3.setMaxWidth(Integer.MAX_VALUE);
		HBox.setMargin(button3, new Insets(10));
		HBox.setHgrow(button3, Priority.SOMETIMES);

		Region region = new Region();
		HBox.setHgrow(region, Priority.ALWAYS);

		hbox.getChildren().addAll(button1, button2, region, button3);

		Scene scene = new Scene(hbox, 400, 200);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
