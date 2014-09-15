package com.example.contacts.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.web.bindery.event.shared.Event;

public class ShowPresenterEvent extends Event<ShowPresenterEvent.ShowPresenterHandler>{

interface ShowPresenterHandler extends EventHandler{

}

@Override
public com.google.web.bindery.event.shared.Event.Type<ShowPresenterHandler> getAssociatedType() {
	// TODO Auto-generated method stub
	return null;
}

@Override
protected void dispatch(ShowPresenterHandler handler) {
	// TODO Auto-generated method stub

}
}
