package com.example.contacts.client;

import com.example.contacts.shared.Contact;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class ContactEditPopupPresenter {

	private ContactEditPopupInterface view;
	private Contact contact;

	public ContactEditPopupPresenter(final Contact contact) {
		this.contact = contact;
	}
	
	public void init() {
		view.addSaveClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				contact.setFirstName(view.getFirstName());
				contact.setLastName(view.getLastName());
				contact.setEmailAddress(view.getEmail());
				view.hide();
			}
		});
		view.setFirstName(contact.getFirstName());
		view.setLastName(contact.getLastName());
		view.setEmail(contact.getEmailAddress());
	}

	public void addSaveClickHandler(ClickHandler clickHandler) {
		view.addSaveClickHandler(clickHandler);
	}

	public void show() {
		view.show();
	}
	
	public ContactEditPopupInterface setView(ContactEditPopupInterface view) {
		return this.view = view;
	}
}
