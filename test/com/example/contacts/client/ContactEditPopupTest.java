package com.example.contacts.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.junit.client.GWTTestCase;

import com.example.contacts.shared.Contact;
import junit.framework.Assert;
import org.junit.Test;


public class ContactEditPopupTest extends GWTTestCase
{

	private void setup() {
	}

	@Override
	public String getModuleName() {
		return "com.example.contacts.ContactsApp";
	}

    @Test
	public void testNewContact() {
		//Test method
		final Contact contact = new Contact();
		ContactEditPopup popup = new ContactEditPopup(contact);
		popup.getFirstNameField().setText("Thomas");
		popup.getLastNameField().setText("Mueller");
		popup.getEmailField().setText("thomas.mueller@fcb.de");
		popup.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Assert.assertEquals("Thomas", contact.getFirstName());
				Assert.assertEquals("Mueller", contact.getLastName());
				Assert.assertEquals("Thomas", contact.getEmailAddress());
			}
		});
		popup.getCmdSave().click();
	}
}
