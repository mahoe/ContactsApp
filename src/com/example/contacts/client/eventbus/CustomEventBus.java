package com.example.contacts.client.eventbus;

import com.google.gwt.event.shared.SimpleEventBus;

public class CustomEventBus {

	private static SimpleEventBus simpleEventBus;

	public static SimpleEventBus getInstance() {
		if (simpleEventBus == null)
		{
			simpleEventBus = new SimpleEventBus();
		}
		return simpleEventBus;
	}
}
