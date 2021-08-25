package com.javacodejunkie;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;
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

		MenuBar menuBar = new MenuBar();
		
		Menu fileMenu = new Menu("_File");
		
		MenuItem openItem = new MenuItem("_Open");
		
		openItem.setOnAction(e -> System.out.println("Open Menu Item Selected"));
		
		MenuItem saveItem = new MenuItem("Save");
		
		saveItem.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
		
		saveItem.setOnAction(e -> System.out.println("Save Menu Item Selected"));
		
		MenuItem exitItem = new MenuItem("Exit");
		
		fileMenu.getItems().addAll(openItem, saveItem, new SeparatorMenuItem(), exitItem);
		
		Menu editMenu = new Menu("Edit");
		
		MenuItem cutItem = new MenuItem("Cut");
		MenuItem copyItem = new MenuItem("Copy");
		MenuItem pasteItem = new MenuItem("Paste");
		
		editMenu.getItems().addAll(cutItem, copyItem, pasteItem);

		Menu helpMenu = new Menu("Help");
		
		MenuItem aboutItem = new MenuItem("About");
		
		helpMenu.getItems().addAll(aboutItem);
		
		menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
		
		root.setTop(menuBar);
		
		scene = new Scene(root, 800, 500);
		scene.getStylesheets().add("/com/javacodejunkie/stylesheet.css");
		stage.setTitle("Java Code Junkie - Menu Demo");
		stage.setScene(scene);
	}

	public void show() {
		this.stage.show();
	}
}
