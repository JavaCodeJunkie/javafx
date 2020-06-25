package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("Master JavaFX CSS");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Label title = new Label("Application Login");
		title.setId("title");
		Label userName = new Label("User Name:");
		TextField userTextField = new TextField();
		Label password = new Label("Password:");
		PasswordField passwordBox = new PasswordField();
		final Label actionText = new Label();

		Button loginButton = new Button("Login");
		loginButton.getStyleClass().add("fancy-button");
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				actionText.setTextFill(Color.FUCHSIA);
				actionText.setText("Login button pressed");
			}
		});

		Button cancelButton = new Button("Cancel");
		cancelButton.getStyleClass().add("fancy-button");
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				actionText.setTextFill(Color.FUCHSIA);
				Platform.exit();
			}
		});

		HBox hboxButtons = new HBox(10);
		hboxButtons.setAlignment(Pos.BOTTOM_RIGHT);
		hboxButtons.getChildren().addAll(loginButton, cancelButton);

		grid.add(title, 0, 0, 2, 1);
		grid.add(userName, 0, 1, 1, 1);
		grid.add(userTextField, 1, 1, 1, 1);
		grid.add(password, 0, 2, 1, 1);
		grid.add(passwordBox, 1, 2, 1, 1);
		grid.add(hboxButtons, 1, 4, 1, 1);
		grid.add(actionText, 0, 6, 2, 1);

		Scene scene = new Scene(grid, 600, 400);
		scene.getStylesheets().add("application/stylesheet.css");
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
