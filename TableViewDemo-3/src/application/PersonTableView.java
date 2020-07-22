package application;

import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.util.converter.IntegerStringConverter;

public class PersonTableView extends VBox {
	
	private TableView<Person> table;
	private TableColumn<Person, String> firstNameColumn;
	private TableColumn<Person, String> lastNameColumn;
	private TableColumn<Person, Integer> ageColumn;
	
	public PersonTableView() {
		buildUI();
	}

	private void buildUI() {
		
		table = new TableView<Person>();
		table.setEditable(true);
				
		firstNameColumn = new TableColumn<Person, String>("First Name");
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		firstNameColumn.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
			@Override
			public void handle(CellEditEvent<Person, String> event) {
				Person person = event.getRowValue();
				person.setFirstName(event.getNewValue());
			}
		});


		lastNameColumn = new TableColumn<Person, String>("Last Name");
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		lastNameColumn.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
			@Override
			public void handle(CellEditEvent<Person, String> event) {
				Person person = event.getRowValue();
				person.setLastName(event.getNewValue());
			}
		});

		ageColumn = new TableColumn<Person, Integer>("Age");
		ageColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
		ageColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		ageColumn.setOnEditCommit(new EventHandler<CellEditEvent<Person, Integer>>() {
			@Override
			public void handle(CellEditEvent<Person, Integer> event) {
				Person person = event.getRowValue();
				person.setAge(event.getNewValue());
			}
		});
		
		table.getColumns().add(firstNameColumn);
		table.getColumns().add(lastNameColumn);
		table.getColumns().add(ageColumn);
		
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		getChildren().add(table);

	}
	
	public void add(Person person) {
		table.getItems().add(person);
	}
}
