package com.javacodejunkie;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainView {

	public Stage stage;
	private Scene scene;

	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}

	private void buildUI() {
		StackPane stackPane = new StackPane();
		
		// Layer 1 - Image
		ImageView iview = new ImageView("/com/javacodejunkie/yoda.jpg");
		stackPane.getChildren().add(iview);
		
		// Layer 2 - Label
		Label label = new Label(" Do, or do not! There is no try! ");
		stackPane.getChildren().add(label);
		StackPane.setAlignment(label, Pos.BOTTOM_CENTER);
		
		// Layer 3 - Button
		Button button = new Button("Click");
		button.setOnAction(e -> label.setText(" Always pass on what you have learned "));
		stackPane.getChildren().add(button);
		StackPane.setAlignment(button, Pos.TOP_RIGHT);
		

		scene = new Scene(stackPane);
		scene.getStylesheets().add("/com/javacodejunkie/stylesheet.css");
		stage.setTitle("Java Code Junkie - StackPane Demo");
		stage.setScene(scene);
	}

	public void show() {
		this.stage.show();
	}
}
