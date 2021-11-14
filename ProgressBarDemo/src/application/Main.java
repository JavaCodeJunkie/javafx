package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			ProgressBar progressBar = new ProgressBar(0);
			
			progressBar.setProgress(0.75);
			
			Double currentProgress = progressBar.getProgress();
			
			System.out.println(currentProgress);
			
			progressBar.setPrefSize(300, 25);
			
			root.setCenter(progressBar);
			
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("ProgressBar Demo");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
