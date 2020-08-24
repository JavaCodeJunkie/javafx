package com.javacodejunkie;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PersonTable extends VBox {

	private TableView<Person> table;
	private TableColumn<Person, String> firstNameColumn;
	private TableColumn<Person, String> lastNameColumn;

	public PersonTable() {
		table = new TableView<Person>();
		firstNameColumn = new TableColumn<Person, String>("First Name");
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameColumn = new TableColumn<Person, String>("Last Name");
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		table.getColumns().add(firstNameColumn);
		table.getColumns().add(lastNameColumn);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		getChildren().add(table);
		setPadding(new Insets(10));
		VBox.setVgrow(table, Priority.ALWAYS);
	}

	public void addPerson(Person person) {
		table.getItems().add(person);
	}

	public void removePerson(Person person) {
		table.getItems().remove(person);
	}
}
