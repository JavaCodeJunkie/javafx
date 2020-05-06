package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

class SaveButtonHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		System.out.println("Save button clicked");
	}
}

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			Image image = new Image(getClass().getResourceAsStream("save.png"));
			ImageView iview = new ImageView(image);
			Button button = new Button("_Save", iview);

			button.setOnAction(new SaveButtonHandler());
			//button.setOnAction(event -> System.out.println("Save button clicked"));
			
			//button.setFont(new Font("Roboto", 18));

			//button.setRotate(270);

			root.setCenter(button);

			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Button Explorer");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
