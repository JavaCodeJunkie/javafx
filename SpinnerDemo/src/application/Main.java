package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("Spinner Demo");

		GridPane root = new GridPane();
		root.setPadding(new Insets(10));
		root.setHgap(10);
		root.setVgap(10);
		
		Spinner<Integer> spinner = new Spinner<>(1, 10, 5);
		
		root.add(spinner, 0, 0);
		
		spinner.getValueFactory().wrapAroundProperty().set(true);
		
		spinner.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);

		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
