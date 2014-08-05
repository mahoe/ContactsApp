package com.example.contacts.client;

import org.junit.Assert;
import org.junit.Test;

import com.example.contacts.shared.Contact;
import com.google.gwt.event.dom.client.ClickHandler;

public class ContactEditPopup2Test {

	@Test
	public void testNewContact() {
		final Contact contact = new Contact();
		contact.setFirstName("Thomas");
		contact.setLastName("Mueller");
		contact.setEmailAddress("thomas.mueller@fcb.de");
		
		ContactEditPopupPresenter contactEditPresenter = new ContactEditPopupPresenter(contact);
		contactEditPresenter.setView(new ContactEditPopupInterface() {
			@Override
			public void show() {
				
			}
			
			@Override
			public void setLastName(String lastName) {
				Assert.assertEquals("Mueller", lastName);
			}
			
			@Override
			public void setFirstName(String firstName) {
				Assert.assertEquals("Thomas", firstName);
			}
			
			@Override
			public void setEmail(String emailAddress) {
				Assert.assertEquals("thomas.mueller@fcb.de", emailAddress);
			}
			
			@Override
			public void hide() {
				
			}
			
			@Override
			public String getLastName() {
				Assert.fail();
				return null;
			}
			
			@Override
			public String getFirstName() {
				Assert.fail();
				return null;
			}
			
			@Override
			public String getEmail() {
				Assert.fail();
				return null;
			}
			
			@Override
			public void addSaveClickHandler(ClickHandler clickHandler) {
				
			}
		});
		
		contactEditPresenter.init();
	}
}
