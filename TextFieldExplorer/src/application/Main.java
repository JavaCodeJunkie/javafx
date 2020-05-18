package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("TextField Explorer");

		// 1. Create new TextField
		TextField textField = new TextField();

		// 2. Set Prompt Text
		textField.setPromptText("Enter some text");
		textField.setFocusTraversable(false);

		// 3. Set On Action
		textField.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Congratulations, you entered some text!");

				// 4. Get Text from TextField
				System.out.println(textField.getText());

				// 5. Set Text on TextField
				textField.setText("I replaced your text!");
			}
		});

		HBox hbox = new HBox(textField);

		Scene scene = new Scene(hbox, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
