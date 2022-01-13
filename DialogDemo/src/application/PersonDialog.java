package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class PersonDialog extends Dialog<Person> {

	private Person person;

	private TextField firstNameField;
	private TextField lastNameField;

	public PersonDialog(Person person) {
		super();
		this.setTitle("Add Person");
		this.person = person;
		buildUI();
		setPropertyBindings();
		setResultConverter();
	}

	private void buildUI() {
		Pane pane = createGridPane();
		getDialogPane().setContent(pane);

		getDialogPane().getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		Node image1 = new ImageView(new Image(getClass().getResourceAsStream("/application/dial.png")));
		// getDialogPane().setGraphic(image1);
		getDialogPane().setHeader(image1);

		getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

		Button button = (Button) getDialogPane().lookupButton(ButtonType.OK);
		button.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!validateDialog()) {
					event.consume();
				}
			}

			private boolean validateDialog() {
				if ((firstNameField.getText().isEmpty()) || (lastNameField.getText().isEmpty())) {
					return false;
				}
				return true;
			}
		});
		getDialogPane().expandableContentProperty().set(new Label("This is the expandable ontent area"));
		getDialogPane().setExpanded(true);
	}

	private void setPropertyBindings() {
		firstNameField.textProperty().bindBidirectional(person.firstNameProperty());
		lastNameField.textProperty().bindBidirectional(person.lastNameProperty());
	}

	private void setResultConverter() {
		Callback<ButtonType, Person> personResultConverter = new Callback<ButtonType, Person>() {
			@Override
			public Person call(ButtonType param) {
				if (param == ButtonType.OK) {
					return person;
				} else {
					return null;
				}
			}
		};
		setResultConverter(personResultConverter);
	}

	public Pane createGridPane() {
		VBox content = new VBox(10);

		Label firstNameLabel = new Label("First Name");
		Label lastNameLabel = new Label("Last Name");
		this.firstNameField = new TextField();
		this.lastNameField = new TextField();
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(5);
		grid.add(firstNameLabel, 0, 0);
		grid.add(lastNameLabel, 0, 1);
		grid.add(firstNameField, 1, 0);
		GridPane.setHgrow(this.firstNameField, Priority.ALWAYS);
		grid.add(lastNameField, 1, 1);
		GridPane.setHgrow(this.lastNameField, Priority.ALWAYS);

		content.getChildren().add(grid);

		return content;
	}
}
