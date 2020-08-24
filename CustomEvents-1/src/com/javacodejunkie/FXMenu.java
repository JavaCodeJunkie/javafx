package com.javacodejunkie;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class FXMenu extends HBox {

	private MenuBar menuBar;
	private Menu fileMenu;
	private MenuItem itemOpen;
	private MenuItem itemSave;
	private MenuItem itemSaveAs;
	private Menu editMenu;
	private Menu helpMenu;

	public FXMenu() {
		buildUI();
	}

	private void buildUI() {
		menuBar = new MenuBar();
		fileMenu = new Menu("File");
		itemOpen = new MenuItem("Open");
		itemSave = new MenuItem("Save");
		itemSaveAs = new MenuItem("Save As...");
		fileMenu.getItems().addAll(itemOpen, itemSave, itemSaveAs);
		editMenu = new Menu("Edit");
		helpMenu = new Menu("Help");
		menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
		getChildren().add(menuBar);
		HBox.setHgrow(menuBar, Priority.ALWAYS);
	}
}
