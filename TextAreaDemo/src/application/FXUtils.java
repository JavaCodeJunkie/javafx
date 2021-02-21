package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXUtils {

	public static HBox createHBox(Node... children) {
		HBox hbox = new HBox(children);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(10);

		return hbox;
	}

	public static VBox createVBox(Node... children) {
		VBox vbox = new VBox(children);
		vbox.setAlignment(Pos.BASELINE_CENTER);
		vbox.setPadding(new Insets(10));
		vbox.setSpacing(10);

		return vbox;
	}

	public static Button createButton(String text) {
		Button button = new Button(text);
		return button;
	}

	public static Button createButtonWithIcon(String text, String url) throws FileNotFoundException {
		Button button = new Button();
		FileInputStream input = new FileInputStream(url);
		Image image = new Image(input);
		ImageView imageView = new ImageView(image);
		button.setText(text);
		button.setGraphic(imageView);
		return button;
	}
}
