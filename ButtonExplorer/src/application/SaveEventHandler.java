package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;

public class SaveEventHandler implements EventHandler<SaveEvent> {

	private Object source;
	private EventTarget target;

	public SaveEventHandler(Object source, EventTarget target) {
		
	}
	
	@Override
	public void handle(SaveEvent event) {
		ActionEvent aevent = new ActionEvent(source, target);
	}
}
