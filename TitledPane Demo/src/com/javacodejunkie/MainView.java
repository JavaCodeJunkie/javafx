package com.javacodejunkie;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
		root.setPadding(new Insets(10));

		// 1. Create a new TitledPane
		TitledPane titledPane = new TitledPane();
		
		// 2. Add content
		GridPane gridPane = createGridPane();
		titledPane.setContent(gridPane);
		
		// 3. Set the Title
		titledPane.setText("Address");
		
		// 4. Expand and Collapse
		titledPane.setExpanded(true);
		
		// 5. Disable Collapsing
		titledPane.setCollapsible(true);
		
		// 6. Set Animation
		titledPane.setAnimated(false);
		

		


		root.setLeft(titledPane);

		scene = new Scene(root, 600, 400);
		scene.getStylesheets().add("/com/javacodejunkie/stylesheet.css");
		stage.setTitle("Java Code Junkie - TitledPane Demo");
		stage.setScene(scene);
	}

	public GridPane createGridPane() {

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.add(new Label("Street Name"), 0, 1);
		gridPane.add(new TextField(), 1, 1);
		gridPane.add(new Label("Street Number"), 0, 0);
		gridPane.add(new TextField(), 1, 0);
		gridPane.add(new Label("City"), 0, 2);
		gridPane.add(new TextField(), 1, 2);
		gridPane.add(new Label("Province"), 0, 3);
		gridPane.add(new TextField(), 1, 3);
		gridPane.add(new Label("Postal Code"), 0, 4);
		gridPane.add(new TextField(), 1, 4);
		
		return gridPane;
	}

	public void show() {
		this.stage.show();
	}
}
