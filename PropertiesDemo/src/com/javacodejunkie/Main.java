package com.javacodejunkie;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Main {

	public static void main(String[] args) {
		Person person = new Person();
		person.setFirstName("Bob");
		System.out.println(person.getFirstName());
		String firstName = person.getFirstName();
		System.out.println(firstName);
		StringProperty firstNameProperty = person.firstNameProperty();
		firstNameProperty.addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("First Name changed from " + oldValue + " to " +newValue);
			}
		});
		person.setFirstName("Buddy");
	}

}
