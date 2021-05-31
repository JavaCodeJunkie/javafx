package application;

import javafx.application.Application;
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
			tabPane.setSide(Side.BOTTOM);
			
//			Tab tab1 = new Tab("Tab 1");
//			tab1.setClosable(false);
//			Button button1 = new Button("Button 1");
//			VBox vbox1 = new VBox(10);
//			vbox1.getChildren().addAll(button1);
//			tab1.setContent(vbox1);
//			
//			tabPane.getTabs().add(tab1);
//			
//			Tab tab2 = new Tab("Tab 2");
//			tab2.setClosable(false);
//			Button button2 = new Button("Button 2");
//			tab2.setContent(button2);
//
//			tabPane.getTabs().add(tab2);
//			
//			tabPane.getSelectionModel().select(1);
			
			for (int i = 1; i<= 20; i++) {
				Tab tab = new Tab("Tab" + Integer.toString(i));
				Button button = new Button("Button" + Integer.toString(i));
				tab.setContent(button);
				tabPane.getTabs().add(tab);
			}
			
			
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
