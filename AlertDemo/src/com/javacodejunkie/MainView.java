package com.javacodejunkie;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainView {

	public Stage stage;
	private StackPane root;
	private Scene scene;

	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}

	private void buildUI() {
		root = new StackPane();

		Button button = new Button("Show Alert");

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Please Confirm");
				alert.setHeaderText("Please consider Subscribing");
				alert.setContentText("Please Subscribe so that you will be notified when I release new videos");
				
				Optional<ButtonType> result = alert.showAndWait();
				if (result.isPresent() && result.get() == ButtonType.OK) {
					System.out.println("OK Button Clicked");
				}
			}
		});
		
		root.getChildren().addAll(button);

		scene = new Scene(root, 800, 500);
		scene.getStylesheets().add("/com/javacodejunkie/stylesheet.css");
		stage.setTitle("Java Code Junkie - Alert Demo");
		stage.setScene(scene);
	}

	public void show() {
		this.stage.show();
	}
}
