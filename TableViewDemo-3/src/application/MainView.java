package application;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainView {
	
	private Stage stage;
	private PersonTableView table;
	
	public MainView() {
		buildUI();
	}

	private void buildUI() {
		stage = new Stage(StageStyle.DECORATED);
		
		BorderPane root = new BorderPane();
		
		table = new PersonTableView();
		
		table.add(new Person("Buggs", "Bunny", 79));
		table.add(new Person("Daffy", "Duck", 83));
		table.add(new Person("Foghorn", "Leghorn", 74));
		table.add(new Person("Elmer", "Fudd", 83));
		table.add(new Person("Tweety", "Bird", 73));
		
		root.setCenter(table);

		Scene scene = new Scene(root, 500, 300);
		scene.getStylesheets().add("application/stylesheet.css");
		stage.setTitle("TableView Demo");
		stage.setScene(scene);
		stage.show();
		
	}

}
