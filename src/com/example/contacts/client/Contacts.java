package com.example.contacts.client;

import com.example.contacts.client.event.ShowContactsListEvent;
import com.example.contacts.client.eventbus.CustomEventBus;
import com.example.contacts.client.gin.OurGinjector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class Contacts implements EntryPoint {

	@Override
	public void onModuleLoad() {
        OurGinjector ginjector = GWT.create(OurGinjector.class);
        final MasterPresenter presenter = ginjector.getMasterPresenter();
		CustomEventBus.getInstance().fireEvent(new ShowContactsListEvent());
	}
}
