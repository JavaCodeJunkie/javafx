package application;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	private Button addButton = new Button("Add Person");
	private ListView<String> listView = new ListView<>();

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Dialog Demo");
			BorderPane root = new BorderPane();
			
			addButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Dialog<Person> personDialog = new PersonDialog(new Person("", ""));
					Optional<Person> result = personDialog.showAndWait();
					if (result.isPresent()) {
						Person person = result.get();
						listView.getItems().add(person.getFirstName() + " " + person.getLastName());
					}
				}
			});

			VBox vbox = new VBox(10);
			vbox.setAlignment(Pos.CENTER);
			vbox.setPadding(new Insets(10));
			vbox.getChildren().addAll(addButton, listView);
			root.setCenter(vbox);

			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
