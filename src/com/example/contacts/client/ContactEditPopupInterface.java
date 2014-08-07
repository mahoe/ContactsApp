package com.example.contacts.client;

public interface ContactEditPopupInterface {

    void addSaveHandler(SaveHandler handler);

    String getFirstName();

	String getLastName();

	String getEmail();

	void hide();

	void setFirstName(String firstName);

	void setLastName(String lastName);

	void setEmail(String emailAddress);

	void show();

}
