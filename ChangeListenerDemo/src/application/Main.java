package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

	private Slider slider;
	private Label label;
	private VBox vbox;

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("ChangeListener Demo");
			BorderPane root = new BorderPane();

			slider = createSlider();
			label = new Label("Font Size: 24");
			label.setFont(Font.font(24));
			
			vbox = FXUtils.createVBox(slider, label);
			
			root.setCenter(vbox);
			
			slider.valueProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					label.setFont(new Font(newValue.doubleValue()));
					label.setText("Font Size: " + newValue.intValue());
				}
			});
			
			Scene scene = new Scene(root, 1000, 400);
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

	public Slider createSlider() {
		Slider slider = new Slider(12, 144, 24);
		slider.setMajorTickUnit(12);
		slider.setMinorTickCount(3);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setSnapToTicks(true);

		slider.setPrefWidth(500);
		slider.setMinWidth(500);
		slider.setMaxWidth(500);

		return slider;
	}
}
