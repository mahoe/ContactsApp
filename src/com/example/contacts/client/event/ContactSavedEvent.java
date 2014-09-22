package com.example.contacts.client.event;

import com.example.contacts.shared.Contact;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by hoepfner on 22.09.2014.
 */
public class ContactSavedEvent extends GwtEvent<ContactSavedEvent.ContactSavedEventHandler> {

    private Contact contact;

    public ContactSavedEvent(Contact contact) {

        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    public interface ContactSavedEventHandler extends EventHandler {
        void onContactSaved(ContactSavedEvent event);
    }
    public static Type<ContactSavedEventHandler> TYPE = new Type<ContactSavedEventHandler>();

    public Type<ContactSavedEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(ContactSavedEventHandler handler) {
        handler.onContactSaved(this);
    }
}
