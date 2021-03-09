package com.javacodejunkie;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {

	public Stage stage;
	private BorderPane root;
	private Scene scene;

	private Label lblQuestion;
	private RadioButton rdoGoogle;
	private RadioButton rdoBing;
	private RadioButton rdoDuckDuckGo;
	private VBox vbox;
	private HBox hbox;
	private Label statusMessage;
	private ToggleGroup group;

	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}

	private void buildUI() {
		root = new BorderPane();

		lblQuestion = new Label("What is your favourite Search Engine?");
		rdoGoogle = new RadioButton("Google");
//		rdoGoogle.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				statusMessage.setText("You have selected Google!");
//			}
//		});
		rdoBing = new RadioButton("Bing");
		rdoDuckDuckGo = new RadioButton("DuckDuckGo");

		group = new ToggleGroup();
		rdoGoogle.setToggleGroup(group);
		rdoBing.setToggleGroup(group);
		rdoDuckDuckGo.setToggleGroup(group);
		
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
				statusMessage.setText("You have selected " + selectedRadioButton.getText());
			}
		});

		vbox = new VBox(10);
		vbox.setPadding(new Insets(10));
		vbox.getChildren().addAll(lblQuestion, rdoGoogle, rdoBing, rdoDuckDuckGo);
		root.setLeft(vbox);

		hbox = new HBox();
		hbox.setPadding(new Insets(5));
		statusMessage = new Label("Ready");
		hbox.getChildren().add(statusMessage);
		root.setBottom(hbox);

		scene = new Scene(root, 800, 500);
		scene.getStylesheets().add("/com/javacodejunkie/stylesheet.css");
		stage.setTitle("Java Code Junkie - RadioButton Demo");
		stage.setScene(scene);
	}

	public void show() {
		this.stage.show();
	}
}
