package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("init() executing");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start() executing");
		Platform.exit();
	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop() executing");
	}

}
