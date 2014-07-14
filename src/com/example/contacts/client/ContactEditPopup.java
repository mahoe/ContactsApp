package com.example.contacts.client;

import com.example.contacts.shared.Contact;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;

public class ContactEditPopup extends PopupPanel{
	private Button cmdSave = new Button("OK");
	private TextBox firstNameField;
	private TextBox lastNameField;
	private TextBox emailField;
	private Contact contact;
	
	public ContactEditPopup(Contact contact) {
		this.contact = contact;
		FlexTable table = new FlexTable();
		table.setWidget(0, 0, new Label("First Name:"));
		firstNameField = new TextBox();
		firstNameField.setText(contact.getFirstName());
		table.setWidget(0, 1, firstNameField);
		table.setWidget(1, 0, new Label("Last Name:"));
		lastNameField = new TextBox();
		lastNameField.setText(contact.getLastName());
		table.setWidget(1, 1, lastNameField);
		table.setWidget(2, 0, new Label("Email:"));
		emailField = new TextBox();
		emailField.setText(contact.getEmailAddress());
		table.setWidget(2, 1, emailField);
		table.setWidget(3, 1, cmdSave);
		
		cmdSave.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ContactEditPopup.this.contact.setFirstName(firstNameField.getValue());
				ContactEditPopup.this.contact.setLastName(lastNameField.getValue());
				ContactEditPopup.this.contact.setEmailAddress(emailField.getValue());
				ContactEditPopup.this.hide();
			}
		});
		add(table);
	}

	public void addClickHandler(ClickHandler handler) {
		cmdSave.addClickHandler(handler);
	}
}
