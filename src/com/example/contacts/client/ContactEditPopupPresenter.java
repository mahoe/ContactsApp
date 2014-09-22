package com.example.contacts.client;

import com.example.contacts.client.event.ContactSavedEvent;
import com.example.contacts.client.eventbus.CustomEventBus;
import com.example.contacts.shared.Contact;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ContactEditPopupPresenter {

	private ContactEditPopupInterface view;
	private Contact contact;
    private ClientServiceAsync clientServiceAsync = GWT.create(ClientService.class);

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

                // validation

                // save contact
                saveContact(contact);
                view.hide();
            }
        });
		view.setFirstName(contact.getFirstName());
		view.setLastName(contact.getLastName());
		view.setEmail(contact.getEmailAddress());
	}

    private void saveContact(final Contact contact) {
        clientServiceAsync.addContact(contact, new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {

            }

            @Override
            public void onSuccess(Void result) {
                GwtEvent<?> event = new ContactSavedEvent(contact);
                CustomEventBus.getInstance().fireEvent(event);
            }
        });
    }

    public void show() {
		view.show();
	}

	public ContactEditPopupInterface setView(ContactEditPopupInterface view) {
		return this.view = view;
	}
}
