package application;
	
import java.time.LocalDate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("DatePicker Demo");
			BorderPane root = new BorderPane();
			
			DatePicker datePicker = new DatePicker();
			
			datePicker.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.out.println("You have selected the date: " + datePicker.getValue());
				}
			});
			
			//datePicker.setValue(LocalDate.now());
			datePicker.setValue(LocalDate.of(1955, 04, 15));
			
			datePicker.getEditor().clear();
			datePicker.setValue(null);
			
			root.setTop(datePicker);
			
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
