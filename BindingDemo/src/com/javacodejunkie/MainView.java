package com.javacodejunkie;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class MainView {

	private Stage stage;
	private BorderPane root;
	private Scene scene;

	private GridPane gridPane;
	private Label lblFirstName;
	private Label lblLastName;
	private TextField txtFirstName;
	private TextField txtLastName;
	private Button btnSave;
	private Button btnCancel;
	private ButtonBar btnBar;

	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}

	private void buildUI() {
		root = new BorderPane();

		gridPane = createGridPane();

		btnSave.disableProperty().bind(txtFirstName.textProperty().isEmpty().or(txtLastName.textProperty().isEmpty()));
		
		root.setCenter(gridPane);

		scene = new Scene(root);
		scene.getStylesheets().add("/com/javacodejunkie/stylesheet.css");
		stage.setTitle("Java Code Junkie - Binding Demo");
		stage.setScene(scene);
	}

	public void show() {
		this.stage.show();
	}

	public GridPane createGridPane() {
		gridPane = new GridPane();

		lblFirstName = new Label("First Name");
		lblLastName = new Label("Last Name");
		txtFirstName = new TextField();
		txtLastName = new TextField();
		btnSave = new Button("Save");
		btnCancel = new Button("Cancel");
		btnBar = new ButtonBar();
		btnBar.getButtons().addAll(btnSave, btnCancel);

		gridPane.add(lblFirstName, 0, 0, 1, 1);
		gridPane.add(txtFirstName, 1, 0, 1, 1);
		gridPane.add(lblLastName, 0, 1, 1, 1);
		gridPane.add(txtLastName, 1, 1, 1, 1);
		gridPane.add(btnBar, 0, 2, 2, 1);

		gridPane.setHgap(10);
		gridPane.setVgap(5);

		gridPane.setPadding(new Insets(10, 10, 10, 10));

		GridPane.setHgrow(txtFirstName, Priority.ALWAYS);
		GridPane.setHgrow(txtLastName, Priority.ALWAYS);

		return gridPane;
	}
}
