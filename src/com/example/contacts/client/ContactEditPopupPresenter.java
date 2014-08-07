package com.example.contacts.client;

import com.example.contacts.shared.Contact;

public class ContactEditPopupPresenter {

	private ContactEditPopupInterface view;
	private Contact contact;

	public ContactEditPopupPresenter(final Contact contact) {
		this.contact = contact;
	}

	public void init() {
		view.addSaveHandler(new SaveHandler()
        {
            @Override
            public void onSave()
            {
                contact.setFirstName(view.getFirstName());
                contact.setLastName(view.getLastName());
                contact.setEmailAddress(view.getEmail());
                view.hide();
            }
        });
		view.setFirstName(contact.getFirstName());
		view.setLastName(contact.getLastName());
		view.setEmail(contact.getEmailAddress());
	}

	public void addSaveHandler(SaveHandler handler) {
		view.addSaveHandler(handler);
	}

	public void show() {
		view.show();
	}

	public ContactEditPopupInterface setView(ContactEditPopupInterface view) {
		return this.view = view;
	}
}
