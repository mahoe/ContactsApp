package com.example.contacts.client;

import com.example.contacts.client.eventbus.CustomEventBus;

public class MasterPresenter {
	public MasterPresenter() {
		CustomEventBus.getInstance().addHandler(type, handler);
	}

}
