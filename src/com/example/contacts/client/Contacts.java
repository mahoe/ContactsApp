package com.example.contacts.client;

import java.util.List;

import com.example.contacts.shared.Contact;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class Contacts implements EntryPoint {

	ClientServiceAsync service = GWT.create(ClientService.class);
	private List<Contact> list;
	private ContactsView contactsView;
	
	@Override
	public void onModuleLoad() {
		createView();
		service.getContactList(new AsyncCallback<List<Contact>>() {
			
			@Override
			public void onSuccess(List<Contact> result) {
				list = result;
				addContacts(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
	}

	private void createView() {
		contactsView = new ContactsView();
		contactsView.getAddButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Contact c = new Contact();
				editContact(c);
			}
		});
		RootPanel.get().add(contactsView);
	}

	private void addContacts(List<Contact> contacts) {
		for (int i = 0; i < contacts.size(); i++) {
			contactsView.addContact(contacts.get(i), i);
		}
	}

	protected void editContact(final Contact contact) {
		ContactEditPopupPresenter contactEditPresenter = new ContactEditPopupPresenter(contact);
		contactEditPresenter.setView(new ContactEditPopupView());
		contactEditPresenter.init();
		contactEditPresenter.addSaveClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				service.addContact(contact, new AsyncCallback<Void>() {
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
					}

					@Override
					public void onSuccess(Void result) {
						list.add(contact);
						contactsView.addContact(contact, list.size());
					}
				});
			}
		});
		contactEditPresenter.show();
	}
}
