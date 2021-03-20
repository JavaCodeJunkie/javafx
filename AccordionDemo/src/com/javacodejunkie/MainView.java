package com.javacodejunkie;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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

		Accordion accordion = new Accordion();

		TitledPane titledPane1 = createTitledPane("Employees");
		TitledPane titledPane2 = createTitledPane("Cost Centers");
		TitledPane titledPane3 = createTitledPane("Departments");

		accordion.getPanes().addAll(titledPane1, titledPane2, titledPane3);

		accordion.setExpandedPane(titledPane2);

		root.setLeft(accordion);

		scene = new Scene(root, 800, 500);
		scene.getStylesheets().add("/com/javacodejunkie/stylesheet.css");
		stage.setTitle("Java Code Junkie - Accordion Demo");
		stage.setScene(scene);
	}

	public void show() {
		this.stage.show();
	}

	private TitledPane createTitledPane(String title) {

		Button button1 = FXUtils.createButtonWithIcon("Create", "circle.png");
		Button button2 = FXUtils.createButtonWithIcon("Edit", "square.png");
		Button button3 = FXUtils.createButtonWithIcon("Delete", "triangle.png");
		Button button4 = FXUtils.createButtonWithIcon("Search", "octagon.png");

		VBox vbox = FXUtils.createVBox(button1, button2, button3, button4);
		vbox.setAlignment(Pos.TOP_CENTER);

		TitledPane titledPane = new TitledPane(title, vbox);
		titledPane.setText(title);

		return titledPane;
	}
}
