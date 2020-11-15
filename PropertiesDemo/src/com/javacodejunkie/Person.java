package com.javacodejunkie;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	
	private StringProperty firstName;
	
	public Person() {
		firstName = new SimpleStringProperty(this, "firstName", "");
	}
	
	public String getFirstName() {
		return this.firstName.get();
	}
	
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}
	
	public StringProperty firstNameProperty() {
		return this.firstName;
	}

	
}
