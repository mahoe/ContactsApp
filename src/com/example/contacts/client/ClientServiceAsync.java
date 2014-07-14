package com.example.contacts.client;

import java.util.List;

import com.example.contacts.shared.Contact;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ClientServiceAsync {

	void getContactList(AsyncCallback<List<Contact>> callback);

	void addContact(Contact contact, AsyncCallback<Void> callback);

}
