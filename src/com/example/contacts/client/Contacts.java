package com.example.contacts.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class Contacts implements EntryPoint {

	@Override
	public void onModuleLoad() {

		ClientServiceAsync clientServiceAsync = GWT.create(ClientService.class);
		ContactsView contactsView = new ContactsView();
		ContactsPresenter contactsPresenter = new ContactsPresenter(
				clientServiceAsync, contactsView);
		RootPanel.get().add(contactsPresenter.getContactsView());

	}

}
