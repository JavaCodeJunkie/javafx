package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private TextArea textArea;

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("TextArea Demo");
			BorderPane root = new BorderPane();
			
			textArea = new TextArea();
			textArea.setWrapText(true);
			textArea.setEditable(false);
			textArea.appendText("This is some text");
			
			String text = textArea.getText();
			System.out.println(text);
			
			root.setTop(textArea);
			
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
