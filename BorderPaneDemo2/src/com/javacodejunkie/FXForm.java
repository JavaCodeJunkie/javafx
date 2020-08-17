package com.javacodejunkie;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class FXForm extends VBox {

	private GridPane grid;
	private Button btnSave;
	private Label lblFirstName;
	private Label lblLastName;
	private TextField txtFirstName;
	private TextField txtLastName;
	private ButtonBar btnBar;

	public FXForm() {
		grid = new GridPane();

		lblFirstName = new Label("First Name");
		lblLastName = new Label("Last Name");
		txtFirstName = new TextField();
		txtLastName = new TextField();
		btnSave = new Button("Save");

		btnBar = new ButtonBar();
		btnBar.getButtons().addAll(btnSave);

		grid.add(lblFirstName, 0, 0, 1, 1);
		grid.add(txtFirstName, 1, 0, 1, 1);
		grid.add(lblLastName, 0, 1, 1, 1);
		grid.add(txtLastName, 1, 1, 1, 1);
		grid.add(btnBar, 0, 2, 2, 1);

		grid.setHgap(10);
		grid.setVgap(5);

		getChildren().add(grid);
		setPadding(new Insets(10));
		VBox.setVgrow(grid, Priority.ALWAYS);
	}
}
