package application;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Slider Demo");
			BorderPane root = new BorderPane();
			
			Slider slider = new Slider(0, 100, 50);
			slider.setPrefWidth(500);
			slider.setShowTickMarks(true);
			slider.setShowTickLabels(true);
			slider.setMajorTickUnit(10);
			slider.setMinorTickCount(3);
			slider.setBlockIncrement(5);
			slider.setSnapToTicks(true);
			
			Label label = new Label("???");
			
			HBox hbox1 = FXUtils.createHBox(slider, label);
			
			slider.valueProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					label.setText(Integer.toString((int)slider.getValue()));
				}
			});

			
			root.setCenter(hbox1);
			
			
			Scene scene = new Scene(root,700,400);
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
