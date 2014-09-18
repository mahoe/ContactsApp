package com.example.contacts.client;

import com.example.contacts.client.event.ShowContactsListEvent;
import com.example.contacts.client.eventbus.CustomEventBus;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class Contacts implements EntryPoint {

	@Override
	public void onModuleLoad() {

		new MasterPresenter();
		CustomEventBus.getInstance().fireEvent(new ShowContactsListEvent());

	}

}
