package com.example.contacts.client;

import java.util.ArrayList;
import java.util.List;

import com.example.contacts.shared.Contact;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;

import org.junit.Assert;
import org.junit.Test;

public class ContactsTest {

	@Test
	public void testContactsList() {
		final List<Contact> contactList = new ArrayList<Contact>();
		final Contact contact = new Contact();
		contact.setFirstName("Thomas");
		contact.setLastName("Mueller");
		contact.setEmailAddress("thomas.mueller@fcb.de");
		contactList.add(contact);

		ClientServiceAsync async = new ClientServiceAsync() {

			@Override
			public void getContactList(AsyncCallback<List<Contact>> callback) {
				// TODO Auto-generated method stub

			}

			@Override
			public void addContact(Contact contact, AsyncCallback<Void> callback) {
				// TODO Auto-generated method stub

			}
		};

		ContactsPresenter contactsPresenter = new ContactsPresenter(async,
				new ContactsInterface() {

					@Override
					public Widget asWidget() {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public void addContact(Contact contact, int size) {
						Assert.assertEquals(contactList.get(0), contact);

					}

					@Override
					public void addClickHandler(ClickHandler clickHandler) {
						// TODO Auto-generated method stub

					}

					@Override
					public void deleteClickHandler(ClickHandler clickHandler) {
						// TODO Auto-generated method stub

					}
				});
		contactsPresenter.addContacts(contactList);
	}
}
