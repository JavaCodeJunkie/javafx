package com.javacodejunkie;

import javafx.event.Event;
import javafx.event.EventType;

public class PersonEvent extends Event {

	private static final long serialVersionUID = -7295215106662000880L;
	public static final EventType<PersonEvent> PERSON = new EventType<>(Event.ANY, "ANY");
	public static final EventType<PersonEvent> ANY = PERSON;
	public static final EventType<PersonEvent> PERSON_SAVE = new EventType<>(PersonEvent.ANY, "PERSON_SAVE");
	
	private Person person;

	public PersonEvent(EventType<? extends Event> eventType, Person person) {
		super(eventType);
		this.person = person;
	}
	
	public Person getPerson() {
		return this.person;
	}

}
