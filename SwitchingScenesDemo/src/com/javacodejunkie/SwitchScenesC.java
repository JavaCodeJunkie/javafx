package com.javacodejunkie;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchScenesC extends Application {

	private Stage stage;
	private Scene scene;
	private BorderPane borderPane;

	private VBox vbox1;
	private Button button1;

	private VBox vbox2;
	private Button button2;

	@Override
	public void start(Stage primaryStage) throws Exception {

		stage = primaryStage;
		stage.setTitle("Switching Scenes");

		vbox1 = createPaneOne();
		vbox2 = createPaneTwo();

		borderPane = new BorderPane();
		borderPane.setTop(new VBox(new Button("Top")));
		borderPane.setLeft(new VBox(new Button("Left")));
		borderPane.setRight(new VBox(new Button("Right")));
		borderPane.setBottom(new VBox(new Button("Bottom")));
		
		borderPane.setCenter(vbox1);

		scene = new Scene(borderPane, 800, 500);
		scene.getStylesheets().add("/com/javacodejunkie/stylesheet.css");

		stage.setScene(scene);

		stage.show();
	}

	private VBox createPaneOne() {

		button1 = new Button("Click to show Pane 2");
		button1.setOnAction(e -> switchPanes(vbox2));
		vbox1 = new VBox(button1);
		vbox1.setStyle("-fx-background-color: green");

		return vbox1;
	}

	private VBox createPaneTwo() {

		button2 = new Button("Click to show Pane 1");
		button2.setOnAction(e -> switchPanes(vbox1));
		vbox2 = new VBox(button2);
		vbox2.setStyle("-fx-background-color: yellow");

		return vbox2;
	}

	// Switch Layout Panes in Center of BorderPane
	public void switchPanes(Pane pane) {
		borderPane.setCenter(pane);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
