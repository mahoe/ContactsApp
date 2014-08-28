package com.example.contacts.client;

import com.example.contacts.shared.Contact;
import com.google.gwt.event.dom.client.ClickHandler;

import com.google.gwt.user.client.ui.IsWidget;

public interface ContactsInterface extends IsWidget {

	void addClickHandler(ClickHandler clickHandler);

	void deleteClickHandler(ClickHandler clickHandler);

	void addContact(Contact contact, int size);

}
