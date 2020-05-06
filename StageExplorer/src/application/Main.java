package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

class MyStage extends Stage {
	private BorderPane root = new BorderPane();
	private Scene scene = new Scene(root, 400, 300);

	MyStage() {
		initStage();
	}

	MyStage(StageStyle style) {
		this.initStyle(style);
		initStage();
	}

	private void initStage() {
		this.scene.setFill(Color.DODGERBLUE);
		this.setScene(scene);
		this.setTitle("Stage Title");
		this.initModality(Modality.NONE);
		this.setOnCloseRequest(new MyEventHandler());
		this.onCloseRequestProperty().set(new MyEventHandler());
	}

	private class MyEventHandler implements EventHandler<WindowEvent> {
		@Override
		public void handle(WindowEvent event) {
			System.out.println("Window Close Request Received");
		}
	}
}

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Stage stage1 = new MyStage();
			stage1.show();
			Stage stage2 = new MyStage(StageStyle.UTILITY);
			stage2.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
