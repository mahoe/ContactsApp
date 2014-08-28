package com.example.contacts.client;

import java.util.List;

import com.example.contacts.shared.Contact;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ContactsPresenter {
	ClientServiceAsync service;

	private List<Contact> list;
	private ContactsInterface contactsView;

	public ContactsPresenter(ClientServiceAsync service,
			ContactsInterface contactsView) {
		this.service = service;
		this.contactsView = contactsView;
		fetchData();
		createView();
	}

	private void createView() {

		contactsView.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Contact c = new Contact();
				editContact(c);
			}
		});

		contactsView.deleteClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				list.remove(0);

			}
		});

	}

	public ContactsInterface getContactsView() {
		return contactsView;
	}

	public void setContactsView(ContactsInterface contactsInterface) {
		this.contactsView = contactsInterface;
	}

	protected void editContact(final Contact contact) {
		ContactEditPopupPresenter contactEditPresenter = new ContactEditPopupPresenter(
				contact);
		contactEditPresenter.setView(new ContactEditPopupView());
		contactEditPresenter.init();
		contactEditPresenter.addSaveHandler(new SaveHandler() {
			@Override
			public void onSave() {
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

	public void addContacts(List<Contact> contacts) {
		for (int i = 0; i < contacts.size(); i++) {
			contactsView.addContact(contacts.get(i), i);
		}
	}

	private void fetchData() {
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
}
