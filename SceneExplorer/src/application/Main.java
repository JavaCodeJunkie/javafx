package application;
	
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
	private Stage stage;

	@Override
	public void start(Stage primaryStage) {
		this.stage = primaryStage;
		this.stage.setTitle("Primary Stage");

		Parent root = new VBox();

		//Scene scene = new Scene(root);
		//Scene scene = new Scene(root, Color.RED);
		//Scene scene = new Scene(root, 400, 300);
		Scene scene = new Scene(root, 400, 300, Color.RED);
		scene.setCursor(Cursor.CROSSHAIR);
		
		this.stage.setScene(scene);
		this.stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
