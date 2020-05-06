package application;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class SaveEvent extends Event {

	private static final long serialVersionUID = 20121107L;

	public static final EventType<SaveEvent> SAVE = new EventType<SaveEvent>(Event.ANY, "SAVE");

	public static final EventType<SaveEvent> ANY = SAVE;

	public SaveEvent() {
		super(SAVE);
	}

	public SaveEvent(Object source, EventTarget target) {
		super(source, target, SAVE);
	}

	@Override
	public SaveEvent copyFor(Object newSource, EventTarget newTarget) {
		return (SaveEvent) super.copyFor(newSource, newTarget);
	}

	@SuppressWarnings("unchecked")
	@Override
	public EventType<? extends SaveEvent> getEventType() {
		return (EventType<? extends SaveEvent>) super.getEventType();
	}

}
