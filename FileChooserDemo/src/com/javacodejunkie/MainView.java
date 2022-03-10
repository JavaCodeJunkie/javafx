package com.javacodejunkie;

import java.io.File;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MainView {

	public Stage stage;
	private FlowPane root;
	private Scene scene;

	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}

	private void buildUI() {
		root = new FlowPane(10, 10);
		root.setPadding(new Insets(10));
		
		ExtensionFilter ex1 = new ExtensionFilter("Text Files", "*.txt");
		ExtensionFilter ex2 = new ExtensionFilter("all Files", "*.*");

		Button openButton = new Button("Open");
		openButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();
				fileChooser.getExtensionFilters().addAll(ex1, ex2);
				
				fileChooser.setTitle("Open My File");
				
				fileChooser.setInitialDirectory(new File("C:/Files"));
				
				File selectedFile = fileChooser.showOpenDialog(stage);
				if (selectedFile != null) {
					System.out.println("Open File");
					System.out.println(selectedFile.getPath());
				}
			}
		});
		
		
		Button saveButton = new Button("Save");
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();
									
				fileChooser.setTitle("Save My File");
				fileChooser.setInitialDirectory(new File("C:/Files"));
				fileChooser.getExtensionFilters().addAll(ex1, ex2);

				File selectedFile = fileChooser.showSaveDialog(stage);
				if (selectedFile != null) {
					System.out.println("Save File");
					System.out.println(selectedFile.getPath());
				}
			}
		});

		Button multiButton = new Button("Multi");
		multiButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();
						
				fileChooser.setTitle("Open My Files");
				fileChooser.setInitialDirectory(new File("C:/Files"));
				fileChooser.getExtensionFilters().addAll(ex1, ex2);

				System.out.println("Multi Open File");
				List<File> selectedFiles = fileChooser.showOpenMultipleDialog(stage);

				for (File selectedFile : selectedFiles) {
					System.out.println(selectedFile.getPath());
				}
			}
		});
		
		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(openButton, saveButton, multiButton);
		root.getChildren().add(hbox);
		
		scene = new Scene(root, 800, 500);
		scene.getStylesheets().add("/com/javacodejunkie/stylesheet.css");
		stage.setTitle("Java Code Junkie - FileChooser Demo");
		stage.setScene(scene);
	}

	public void show() {
		this.stage.show();
	}
}
