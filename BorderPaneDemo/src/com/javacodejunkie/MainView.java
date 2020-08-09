package com.javacodejunkie;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView {

	private Stage stage;
	private BorderPane root;
	private Scene scene;
	private Insets INSETS = new Insets(10, 10, 10, 10);

	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}

	private void buildUI() {
		root = new BorderPane();
		
		Button top = createButton("Top");
		Button left = createButton("Left");
		Button center = createButton("Center");
		Button right = createButton("Right");
		Button bottom = createButton("Bottom");
		
		root.setTop(top);
		root.setLeft(left);
		root.setCenter(center);
		root.setRight(right);
		root.setBottom(bottom);
		
		scene = new Scene(root);
		scene.getStylesheets().add("/com/javacodejunkie/stylesheet.css");
		stage.setTitle("Java Code Junkie - BorderPane Demo");
		stage.setScene(scene);
		stage.setMinWidth(550);
		stage.setMinHeight(400);
		stage.show();
	}

	private Button createButton(String text) {
		Button button = new Button(text);
		button.setMaxWidth(Double.MAX_VALUE);
		button.setMaxHeight(Double.MAX_VALUE);
		button.setMinWidth(150);
		BorderPane.setMargin(button, INSETS);
		BorderPane.setAlignment(button, Pos.CENTER);
		return button;
	}
}
