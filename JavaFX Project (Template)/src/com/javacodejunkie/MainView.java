package com.javacodejunkie;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView {

	public Stage stage;
	private BorderPane root;
	private Scene scene;

	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}

	private void buildUI() {
		root = new BorderPane();

		scene = new Scene(root, 800, 500);
		scene.getStylesheets().add("/com/javacodejunkie/stylesheet.css");
		stage.setTitle("Java Code Junkie - ???");
		stage.setScene(scene);
	}

	public void show() {
		this.stage.show();
	}
}
