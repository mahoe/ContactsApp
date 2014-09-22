package com.example.contacts.client;

import com.example.contacts.client.event.EditContactEvent;
import com.example.contacts.client.event.EditContactEvent.EditContactHandler;
import com.example.contacts.client.event.ShowContactsListEvent;
import com.example.contacts.client.event.ShowContactsListEvent.ShowPresenterHandler;
import com.example.contacts.client.eventbus.CustomEventBus;
import com.example.contacts.shared.Contact;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class MasterPresenter implements ShowPresenterHandler,
		EditContactHandler {
	ClientServiceAsync clientServiceAsync = GWT.create(ClientService.class);
	private ContactEditPopupPresenter contactEditPopupPresenter;
	private ContactsPresenter contactsPresenter;

	public MasterPresenter() {
		CustomEventBus.getInstance().addHandler(ShowContactsListEvent.TYPE,
				this);
		CustomEventBus.getInstance().addHandler(EditContactEvent.TYPE,  this);
	}

	@Override
	public void onShowPresenter(ShowContactsListEvent event) {

		ContactsView contactsView = new ContactsView();
		if (contactsPresenter == null) {

			contactsPresenter = new ContactsPresenter(clientServiceAsync,
					contactsView);
		}
		RootPanel.get().add(contactsPresenter.getContactsView());
	}

	@Override
	public void onEditPresenter(EditContactEvent event) {
		final Contact contact = event.getContact();
		if (contactEditPopupPresenter == null) {
			contactEditPopupPresenter = new ContactEditPopupPresenter(
					contact);
		}


		contactEditPopupPresenter.setView(new ContactEditPopupView());
		contactEditPopupPresenter.init();
		contactEditPopupPresenter.show();


	}

}
