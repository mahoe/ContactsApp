package com.example.contacts.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.web.bindery.event.shared.Event;

public class ShowContactsListEvent extends
		Event<ShowContactsListEvent.ShowPresenterHandler> {

	public interface ShowPresenterHandler extends EventHandler {
		void onShowPresenter(ShowContactsListEvent event);

	}

	public static final Type<ShowPresenterHandler> TYPE = new Type<ShowPresenterHandler>();

	@Override
	public Type<ShowPresenterHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ShowPresenterHandler handler) {
		handler.onShowPresenter(this);
	}
}
