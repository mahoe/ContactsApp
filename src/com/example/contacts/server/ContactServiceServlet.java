package com.example.contacts.server;

import java.util.ArrayList;
import java.util.List;

import com.example.contacts.client.ClientService;
import com.example.contacts.shared.Contact;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ContactServiceServlet extends RemoteServiceServlet implements ClientService {
	private static final long serialVersionUID = 1L;
	private List<Contact> list = new ArrayList<>();
	
	public ContactServiceServlet() {
		list.add(new Contact("Hans", "Wurst", "hans.wurst@server.com"));
		list.add(new Contact("Nuno", "Graca", "nugra@server.com"));
		list.add(new Contact("Otto", "Motor", "otto.motor@server.com"));
	}
	
	public List<Contact> getContactList()
	{
		return list;
	}

	@Override
	public void addContact(Contact contact) {
		list.add(contact);		
	}
}
