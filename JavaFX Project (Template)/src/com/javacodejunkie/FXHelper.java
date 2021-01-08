package com.javacodejunkie;

import java.util.List;
import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FXHelper {

	private FXHelper() {
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
