package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage stage;
	private Scene scene;
	private GridPane root;
	private Label nameLabel;
	private Label passwordLabel;
	private TextField name;
	private PasswordField password;
	private Button loginButton;
	private Button cancelButton;

	private TextArea eventLog;

	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		stage.setTitle("Event Handling II");
		createUI();
		addEventHandlers();
		stage.show();
	}

	private void addEventHandlers() {
		// stage.
	}

	private void createUI() {
		root = new GridPane();
		nameLabel = new Label("Username");
		name = new TextField();
		name.setPrefColumnCount(20);
		passwordLabel = new Label("Password");
		password = new PasswordField();
		password.setPrefColumnCount(20);

		loginButton = new Button("_Login");
		cancelButton = new Button("_Cancel");

		eventLog = new TextArea();

		root.add(nameLabel, 0, 0, 1, 1);
		root.add(name, 1, 0, 1, 1);
		root.add(loginButton, 2, 0, 1, 1);

		root.add(passwordLabel, 0, 1, 1, 1);
		root.add(password, 1, 1, 1, 1);
		root.add(cancelButton, 2, 1, 1, 1);

		root.add(eventLog, 0, 2, 3, 5);

		scene = new Scene(root);

		stage.setScene(scene);

		String stylesheet = getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(stylesheet);
		root.getStyleClass().add("grid-pane");

		name.requestFocus();

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
