package application;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class Sphere3D extends Application {

	private static final int WIDTH = 1400;
	private static final int HEIGHT = 800;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Sphere sphere = new Sphere(50);

		Group group = new Group();
		group.getChildren().add(sphere);

		Camera camera = new PerspectiveCamera();
		Scene scene = new Scene(group, WIDTH, HEIGHT);
		scene.setFill(Color.LAWNGREEN);
		scene.setCamera(camera);

		sphere.translateXProperty().set(WIDTH / 2);
		sphere.translateYProperty().set(HEIGHT / 2);

		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			switch (event.getCode()) {
			case W:
				sphere.translateZProperty().set(sphere.getTranslateZ() + 100);
				break;
			case S:
				sphere.translateZProperty().set(sphere.getTranslateZ() - 100);
				break;
			default:
				break;
			}
		});

		primaryStage.setTitle("Genuine Coder");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
