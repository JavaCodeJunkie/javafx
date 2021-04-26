package com.javacodejunkie;

import java.util.Optional;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainView {

	public Stage stage;
	private BorderPane root;
	private Scene scene;

	public MainView(Stage stage) {
		this.stage = stage;
		initialize();
	}

	private void initialize() {

		stage.setTitle("Java Code Junkie - Window Events");
		root = new BorderPane();
		scene = new Scene(root, 500, 300);
		stage.setScene(scene);

//		stage.addEventHandler(WindowEvent.ANY, new EventHandler<WindowEvent>() {
//			@Override
//			public void handle(WindowEvent event) {
//				System.out.println(event.getEventType());
//			}
//		});

		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Exit Program");
				alert.setHeaderText("Confirm Exit");
				alert.setContentText("Are you sure that you want to exit the program?");

				Optional<ButtonType> result = alert.showAndWait();

				if (result.isPresent() && result.get() == ButtonType.OK) {
					Platform.exit();
				} else {
					event.consume();
				}
			}
		});

	}

	public void show() {
		this.stage.show();
	}
}
