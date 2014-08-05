package com.example.contacts.client;

import com.google.gwt.event.dom.client.ClickHandler;

public interface ContactEditPopupInterface {

	void addSaveClickHandler(ClickHandler clickHandler);

	String getFirstName();

	String getLastName();

	String getEmail();

	void hide();

	void setFirstName(String firstName);

	void setLastName(String lastName);

	void setEmail(String emailAddress);

	void show();
	
}
