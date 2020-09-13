package com.javacodejunkie;

import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

	@Override
	public void start(Stage primaryStage) {
		MainView mainView = new MainView(primaryStage);
		mainView.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
