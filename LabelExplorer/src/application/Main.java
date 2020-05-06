package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Label Explorer");
			BorderPane root = new BorderPane();
			
			Image image = new Image(getClass().getResourceAsStream("ok.png"));
			ImageView iview = new ImageView(image);

			//Creates an empty label
			//Label label = new Label();	

			//Creates Label with supplied text.
			//Label label = new Label(text);

			//Creates a Label with the supplied text and graphic.
			Label label = new Label("Everything is ok!", iview);

			label.setFont(new Font("Roboto", 18));

			//label.setRotate(270);
			//label.setText("I think everything is ok!?");
			
			root.setCenter(label);
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
