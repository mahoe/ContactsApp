package com.example.contacts.client.event;

import com.example.contacts.shared.Contact;
import com.google.gwt.event.shared.EventHandler;
import com.google.web.bindery.event.shared.Event;

public class EditContactEvent extends
		Event<EditContactEvent.EditContactHandler> {

	public interface EditContactHandler extends EventHandler {
		void onEditPresenter(EditContactEvent event);

	}

	public static final Type<EditContactHandler> TYPE = new Type<EditContactHandler>();
	private Contact contact;

	public EditContactEvent(Contact contact) {
		this.contact = contact;
	}

	@Override
	public Type<EditContactHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EditContactHandler handler) {
		handler.onEditPresenter(this);
	}

	public Contact getContact() {
		return contact;
	}

}
