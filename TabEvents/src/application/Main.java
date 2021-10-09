package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage stage;
	private TabPane tabPane;

	@Override
	public void start(Stage primaryStage) {
		try {
			this.stage = primaryStage;
			stage.setTitle("TabPane Demo");
			BorderPane root = new BorderPane();

			tabPane = new TabPane();
			tabPane.setSide(Side.TOP);

			Tab tab1 = new Tab("Tab 1");
			tab1.setClosable(true);
			Button button1 = new Button("Button 1");
			VBox vbox1 = new VBox(10);
			vbox1.setAlignment(Pos.CENTER);
			vbox1.getChildren().addAll(button1);
			tab1.setContent(vbox1);
			
			tab1.setOnSelectionChanged(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					System.out.println(event.getEventType());
				}
			});
			
			tab1.setOnCloseRequest(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					System.out.println(event.getEventType());
				}
			});
			
			tab1.setOnClosed(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					System.out.println(event.getEventType());
				}
			});
			
			tab1.selectedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					System.out.println("Old: " + oldValue + " New: " + newValue);
				}
			});

			tabPane.getTabs().add(tab1);

			Tab tab2 = new Tab("Tab 2");
			tab2.setClosable(true);
			Button button2 = new Button("Button 2");
			VBox vbox2 = new VBox(10);
			vbox2.setAlignment(Pos.CENTER);
			vbox2.getChildren().addAll(button2);
			tab2.setContent(vbox2);

			tabPane.getTabs().add(tab2);

			root.setCenter(tabPane);

			Scene scene = new Scene(root, 800, 500);
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
