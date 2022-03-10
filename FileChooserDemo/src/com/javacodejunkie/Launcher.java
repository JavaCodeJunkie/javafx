package com.javacodejunkie;

import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

	@Override
	public void start(Stage stage) {
		MainView mainView = new MainView(stage);
		mainView.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
