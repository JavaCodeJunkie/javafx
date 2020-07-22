package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class TableViewDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		new MainView();
	}
}
