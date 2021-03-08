package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Text Demo");
			BorderPane root = new BorderPane();
			
			Text text = new Text("This is some longer text that will wrap at a predetermined pixel width");
			
			text.setFont(Font.font("Roboto Black", FontWeight.BOLD, 36));
			
			text.setFill(Color.YELLOW);
			
			text.setStroke(Color.GREEN);
			
			text.setStrokeWidth(1.5);
			
			//text.setStrikethrough(true);
			
			//text.setUnderline(true);
			
			//DropShadow shadow = new DropShadow();
			//text.setEffect(shadow);
			
			//text.setEffect(new Reflection());
			
			//text.setEffect(new BoxBlur());
			
			text.setWrappingWidth(500);
			
			text.setTextAlignment(TextAlignment.JUSTIFY);
			
			
			
			root.setCenter(text);
			
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
