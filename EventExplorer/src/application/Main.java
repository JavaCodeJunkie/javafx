package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

class MyEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		System.out.println(
				"Source: " + event.getSource() + " Type: " + event.getEventType() + " Target: " + event.getTarget());
	}

}

public class Main extends Application {

	private Stage stage;
	private Scene scene;
	private BorderPane root;
	private Button button;
	private Label label;

	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		stage.setTitle("Event Explorer");
		root = new BorderPane();

		EventHandler<ActionEvent> theEventHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Source: " + event.getSource() + " Type: " + event.getEventType() + " Target: "
						+ event.getTarget());
			}
		};

		// root.addEventFilter(ActionEvent.ACTION, theEventHandler);
		// root.addEventHandler(ActionEvent.ACTION, theEventHandler);

		root.addEventFilter(ActionEvent.ACTION, new MyEventHandler());
		root.addEventHandler(ActionEvent.ACTION, new MyEventHandler());

		EventHandler<ActionEvent> actionEventHandler = event -> {
			System.out.println("Source: " + event.getSource() + " Type: " + event.getEventType() + " Target: "
					+ event.getTarget());
		};

		root.addEventFilter(ActionEvent.ACTION, actionEventHandler);
		root.addEventHandler(ActionEvent.ACTION, actionEventHandler);

		/*
		 * root.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent event) {
		 * System.out.println("Source: " + event.getSource() + " Type: " +
		 * event.getEventType() + " Target: " + event.getTarget()); // event.consume();
		 * } });
		 * 
		 * root.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent event) {
		 * System.out.println("Source: " + event.getSource() + " Type: " +
		 * event.getEventType() + " Target: " + event.getTarget()); } });
		 */
		scene = new Scene(root, 700, 500);
		button = new Button("Click me");
		/*
		 * button.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent event) {
		 * System.out.println("Source: " + event.getSource() + " Type: " +
		 * event.getEventType() + " Target: " + event.getTarget()); } });
		 */
		button.setOnAction(new MyEventHandler());

		label = new Label();
		root.setCenter(button);
		root.setBottom(label);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
