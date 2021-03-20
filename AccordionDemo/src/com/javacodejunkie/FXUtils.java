package com.javacodejunkie;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Tooltip;
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
		vbox.setAlignment(Pos.TOP_CENTER);
		vbox.setPadding(new Insets(10));
		vbox.setSpacing(10);

		return vbox;
	}

	public static Button createButton(String text) {
		Button button = new Button(text);
		return button;
	}

	public static Button createButtonWithIcon(String text, String url) {
		Button button = new Button();
		FileInputStream input = null;
		try {
			input = new FileInputStream(url);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to locate image file: " + url);
		}
		Image image = new Image(input);
		ImageView imageView = new ImageView(image);
		button.setText(text);
		button.setGraphic(imageView);
		button.setAlignment(Pos.CENTER_LEFT);
		button.setGraphicTextGap(10);
		button.setPrefWidth(150);
		return button;
	}

	public static void setTooltip(Control control, String message) {
		if (message.isEmpty()) {
			throw new IllegalArgumentException("The message cannot be empty.");
		}
		control.setTooltip(new Tooltip(message));
	}

	public static Button createImageButton(String imagePath, int width, int height) {
		if (imagePath.isEmpty()) {
			throw new IllegalArgumentException("The image path cannot be empty.");
		}
		Button button = new Button();
		Image image = new Image(imagePath, (double) width, (double) height, true, true);
		button.setGraphic(new ImageView(image));
		return button;
	}

	public static ComboBox<String> createComboBox(final String... options) {
		ObservableList<String> list = FXCollections.observableArrayList();

		for (String option : options) {
			if (option != null) {
				list.add(option);
			}
		}
		return new ComboBox<String>(list);
	}

	public static ComboBox<String> createComboBox(final List<String> options) {
		options.removeIf(Objects::isNull);
		return new ComboBox<>(FXCollections.observableArrayList(options));
	}
}
