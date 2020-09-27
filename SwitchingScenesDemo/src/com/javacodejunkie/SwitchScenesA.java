package com.javacodejunkie;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SwitchScenesA extends Application {
	
	// Two Stages and two Scenes

	private Stage stage1;
	private Scene scene1;
	private VBox vbox1;
	private Button button1;

	private Stage stage2;
	private Scene scene2;
	private VBox vbox2;
	private Button button2;

	@Override
	public void start(Stage primaryStage) throws Exception {

		stage1 = createStageOne();
		stage2 = createStageTwo();

		stage1.show();
	}

	private Stage createStageOne() {

		stage1 = new Stage(StageStyle.DECORATED);
		stage1.setTitle("Stage 1");
		button1 = new Button("Click to show Stage 2");
		button1.setOnAction(e -> stage2.show());
		vbox1 = new VBox(button1);
		vbox1.setStyle("-fx-background-color: green");
		scene1 = new Scene(vbox1, 800, 500);
		scene1.getStylesheets().add("/com/javacodejunkie/stylesheet.css");
		stage1.setScene(scene1);

		return stage1;
	}

	private Stage createStageTwo() {
		
		stage2 = new Stage(StageStyle.DECORATED);
		stage2.setTitle("Stage 2");
		stage2.initOwner(stage1);
		stage2.initModality(Modality.APPLICATION_MODAL);
		button2 = new Button("Click to close Stage 2");
		button2.setOnAction(e -> stage2.close());
		vbox2 = new VBox(button2);
		vbox2.setStyle("-fx-background-color: yellow");
		scene2 = new Scene(vbox2, 700, 400);
		scene2.getStylesheets().add("/com/javacodejunkie/stylesheet.css");
		stage2.setScene(scene2);

		return stage2;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
