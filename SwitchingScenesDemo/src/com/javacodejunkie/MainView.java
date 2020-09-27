package com.javacodejunkie;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class MainView {

	private Stage stage;

	private Scene scene1;
	private BorderPane borderPane1;
	private Button button1;
	private TableView<String> tableView1;

	private Scene scene2;
	private BorderPane borderPane2;
	private Button button2;
	private TableView<String> tableView2;

	private GridPane gridPane;
	private TitledPane titledPane;
	private Button button3;
	private Button button4;

	public MainView(Stage primaryStage) {
		stage = primaryStage;

		// Method 1 - Switch complete Scene
		borderPane1 = new BorderPane();
		borderPane1.setStyle("-fx-background-color: red;");
		tableView1 = new TableView<String>();
		borderPane1.setRight(tableView1);
		button1 = new Button("Switch to Scene 2");
		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(scene2);
			}
		});
		HBox hbox1 = new HBox(button1);
		borderPane1.setTop(hbox1);
		scene1 = new Scene(borderPane1, 800, 500);
		scene1.getStylesheets().add("/com/javacodejunkie/stylesheet.css");

		borderPane2 = new BorderPane();
		borderPane2.setStyle("-fx-background-color: green;");
		tableView2 = new TableView<String>();
		borderPane2.setLeft(tableView2);
		button2 = new Button("Switch to Scene 1");
		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(scene1);
			}
		});
		borderPane2.setTop(button2);
		scene2 = new Scene(borderPane2, 800, 500);
		scene2.getStylesheets().add("/com/javacodejunkie/stylesheet.css");

		// Method 2 - Switch Pane within Scene
		gridPane = createGridPane();
		titledPane = createTitledPane();
		button3 = new Button("Switch to TitledPane");
		button3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				borderPane1.setCenter(titledPane);
			}
		});
		button4 = new Button("Switch to GridPane");
		button4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				borderPane1.setCenter(gridPane);
			}
		});
		hbox1.getChildren().addAll(button3, button4);

		stage.setScene(scene1);
		stage.setTitle("Java Code Junkie - Switching Scenes");
	}

	public void switchScene() {
		if (stage.getScene().getRoot() == borderPane1) {
			stage.getScene().setRoot(borderPane2);
		} else {
			stage.getScene().setRoot(borderPane1);
		}
	}

	public void show() {
		this.stage.show();
	}

	public GridPane createGridPane() {
		GridPane grid = new GridPane();

		Label lblFirstName = new Label("First Name");
		Label lblLastName = new Label("Last Name");
		TextField txtFirstName = new TextField();
		TextField txtLastName = new TextField();
		Button btnSave = new Button("Save");
		Button btnCancel = new Button("Cancel");
		ButtonBar btnBar = new ButtonBar();
		btnBar.getButtons().addAll(btnSave, btnCancel);

		grid.add(lblFirstName, 0, 0, 1, 1);
		grid.add(txtFirstName, 1, 0, 1, 1);
		grid.add(lblLastName, 0, 1, 1, 1);
		grid.add(txtLastName, 1, 1, 1, 1);
		grid.add(btnBar, 0, 2, 2, 1);

		grid.setHgap(10);
		grid.setVgap(5);
		grid.setPadding(new Insets(10, 10, 10, 10));

		GridPane.setHalignment(lblFirstName, HPos.RIGHT);
		GridPane.setHalignment(lblLastName, HPos.RIGHT);

		GridPane.setHgrow(txtFirstName, Priority.ALWAYS);
		GridPane.setHgrow(txtLastName, Priority.ALWAYS);

		return grid;
	}

	public TitledPane createTitledPane() {

		TitledPane titledPane = new TitledPane();
		titledPane.setText("Address");

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.add(new Label("Street Name"), 0, 1);
		gridPane.add(new TextField(), 1, 1);
		gridPane.add(new Label("Street Number"), 0, 0);
		gridPane.add(new TextField(), 1, 0);
		gridPane.add(new Label("City"), 0, 2);
		gridPane.add(new TextField(), 1, 2);
		gridPane.add(new Label("Province"), 0, 3);
		gridPane.add(new TextField(), 1, 3);
		gridPane.add(new Label("Postal Code"), 0, 4);
		gridPane.add(new TextField(), 1, 4);
		titledPane.setContent(gridPane);

		return titledPane;
	}
}
