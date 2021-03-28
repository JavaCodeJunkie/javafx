package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("ListView Demo");
			BorderPane root = new BorderPane();

//			ListView<String> listView = new ListView<>();
//			
//			listView.getItems().add("Jerry");
//			listView.getItems().add("Elaine");
//			listView.getItems().add("George");
//			listView.getItems().add("Kramer");
//			listView.getItems().add("Newman");
//			listView.getItems().add("Morty");
//			listView.getItems().add("Helen");
//			listView.getItems().add("Frank");
//			listView.getItems().add("Estelle");
			
			ObservableList<String> names = FXCollections.observableArrayList("Jerry", "Elaine", "George", "Kramer",
					"Newman", "Morty", "Helen", "Frank", "Estelle");
			
			ListView<String> listView = new ListView<>(names);
			
			//listView.setPrefWidth(150);
			//listView.setPrefHeight(200);
			
			//listView.getItems().remove("George");
			
			// listView.getItems().remove(5);
			
			listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					System.out.println("Selected item: " + newValue);
				}
			});
			
			root.setCenter(listView);

			Scene scene = new Scene(root);
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
