package com.javacodejunkie;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {

	private Stage stage;
	private BorderPane root;
	private Scene scene;
	
	private FXMenu fxMenu;
	private FXToolBar fxToolBar;
	private PersonForm fxForm;
	private PersonTable fxTable;
	private FXStatusBar fxStatusBar;

	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}

	private void buildUI() {

		root = new BorderPane();
		root.addEventFilter(PersonEvent.ANY, this::handlePersonEvent);

		fxMenu = new FXMenu();
		fxToolBar = new FXToolBar();

		VBox top = new VBox(fxMenu, fxToolBar);
		root.setTop(top);
		
		fxForm = new PersonForm();
		root.setLeft(fxForm);
		
		fxTable = new PersonTable();
		root.setCenter(fxTable);
		
		fxStatusBar = new FXStatusBar();
		root.setBottom(fxStatusBar);
		
		scene = new Scene(root, 800, 500);
		scene.getStylesheets().add("/com/javacodejunkie/stylesheet.css");
		stage.setTitle("Java Code Junkie - BorderPane Demo 2");
		stage.setScene(scene);
		stage.show();
	}
	
	public void handlePersonEvent(PersonEvent event) {
		System.out.println(event.getPerson().getFirstName()+ " " + event.getPerson().getLastName());
	}
}
