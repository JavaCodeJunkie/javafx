package com.javacodejunkie;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PersonForm extends VBox {

	private GridPane grid;
	private Button btnSave;
	private Label lblFirstName;
	private Label lblLastName;
	private TextField txtFirstName;
	private TextField txtLastName;
	private ButtonBar btnBar;

	public PersonForm() {
		grid = new GridPane();

		lblFirstName = new Label("First Name");
		lblLastName = new Label("Last Name");
		txtFirstName = new TextField();
		txtLastName = new TextField();
		btnSave = new Button("Save");
		btnSave.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Person person = new Person(txtFirstName.getText(), txtLastName.getText());
				btnSave.fireEvent(new PersonEvent(PersonEvent.PERSON_SAVE, person));
			}
		});

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
