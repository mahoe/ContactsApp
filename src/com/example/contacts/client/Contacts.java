package com.example.contacts.client;

import java.util.List;

import com.example.contacts.shared.Contact;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Contacts implements EntryPoint {

	private FlexTable grid = new FlexTable();
	ClientServiceAsync service = GWT.create(ClientService.class);
	private List<Contact> list;
	
	@Override
	public void onModuleLoad() {
		service.getContactList(new AsyncCallback<List<Contact>>() {
			
			@Override
			public void onSuccess(List<Contact> result) {
				list = result;
				createTable();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
		
	}

	private void createTable() {
		VerticalPanel panel = new VerticalPanel();
		
		for (int row=0;row < list.size(); row++) {
			Contact contact = list.get(row);
			grid.setText(row, 0, contact.getFirstName());
			grid.setText(row, 1, contact.getLastName());
			grid.setText(row, 2, contact.getEmailAddress());			
		}
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		Button addButton = new Button("Add");
		Button delButton = new Button("Delete");
		horizontalPanel.add(addButton);
		horizontalPanel.add(delButton);
		panel.add(horizontalPanel);
		panel.add(grid);
		RootPanel.get().add(panel);
		
		addButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Contact c = new Contact();
				editContact(c);
			}
		});
	}

	protected void editContact(final Contact contact) {
		ContactEditPopup popup = new ContactEditPopup(contact);
		popup.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				service.addContact(contact, new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Void result) {
						String firstName = contact.getFirstName();
						grid.setText(list.size(), 0, firstName);
						grid.setText(list.size(), 1, contact.getLastName());
						grid.setText(list.size(), 2, contact.getEmailAddress());		
						list.add(contact);
					}
				});
			}
		});
		popup.show();
		popup.setModal(true);
	}
}
