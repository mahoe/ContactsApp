package com.example.contacts.client;

import com.example.contacts.shared.Contact;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ContactsView extends VerticalPanel {

	private FlexTable grid = new FlexTable();
	private Button addButton;
	private Button delButton;
	
	public ContactsView() {
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		addButton = new Button("Add");
		delButton = new Button("Delete");
		horizontalPanel.add(addButton);
		horizontalPanel.add(delButton);
		add(horizontalPanel);
		add(grid);
	}
	
	public void addContact(Contact contact, int row) {
		grid.setText(row, 0, contact.getFirstName());
		grid.setText(row, 1, contact.getLastName());
		grid.setText(row, 2, contact.getEmailAddress());			
	}

	public Button getAddButton() {
		return addButton;
	}

	public Button getDelButton() {
		return delButton;
	}
}
