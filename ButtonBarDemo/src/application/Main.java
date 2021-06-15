package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			ButtonBar buttonBar = new ButtonBar();
			buttonBar.setPadding(new Insets(10));
			
			Button btnYes = new Button("Yes");
			ButtonBar.setButtonData(btnYes, ButtonData.LEFT);
			
			Button btnNo = new Button("No");
			ButtonBar.setButtonData(btnNo, ButtonData.RIGHT);
			
			buttonBar.getButtons().addAll(btnYes, btnNo);
			
			//buttonBar.setButtonOrder("NY");
			
			root.setBottom(buttonBar);

			Scene scene = new Scene(root, 400, 200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("ButtonBar Demo");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
