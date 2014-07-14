package com.example.contacts.client;

import java.util.List;

import com.example.contacts.shared.Contact;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("client")
public interface ClientService extends RemoteService{
	List<Contact> getContactList();
	void addContact(Contact contact);
}
