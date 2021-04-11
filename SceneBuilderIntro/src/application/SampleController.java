package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SampleController {
	
	@FXML
	private Button button;
	
	@FXML
	private Label label;
	
	@FXML
	public void onButtonClicked(ActionEvent event) {
		label.setText("Button Clicked!");
	}
	
}
