package com.example.contacts.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;

public class ContactEditPopupView extends PopupPanel implements ContactEditPopupInterface {
	private Button cmdSave = new Button("OK");
	private TextBox firstNameField;
	private TextBox lastNameField;
	private TextBox emailField;
    private List<SaveHandler> saveHandlers = new ArrayList<SaveHandler>();

    public ContactEditPopupView() {
		FlexTable table = new FlexTable();
		table.setWidget(0, 0, new Label("First Name:"));
		firstNameField = new TextBox();
		table.setWidget(0, 1, firstNameField);
		table.setWidget(1, 0, new Label("Last Name:"));
		lastNameField = new TextBox();
		table.setWidget(1, 1, lastNameField);
		table.setWidget(2, 0, new Label("Email:"));
		emailField = new TextBox();
		table.setWidget(2, 1, emailField);
		table.setWidget(3, 1, cmdSave);
		add(table);
        cmdSave.addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                onSave();
            }
        });
		this.setModal(true);
	}

    public void onSave()
    {
        for (SaveHandler saveHandler : saveHandlers)
        {
            saveHandler.onSave();
        }
    }

    @Override
    public void addSaveHandler(SaveHandler handler) {
        saveHandlers.add(handler);
	}

	public Button getCmdSave() {
		return cmdSave;
	}

	public String getFirstName() {
		return firstNameField.getValue();
	}

	public void setFirstName(String firstName) {
		this.firstNameField.setValue(firstName);
	}

	public String getLastName() {
		return lastNameField.getValue();
	}

	public void setLastName(String lastName) {
		this.lastNameField.setValue(lastName);
	}

	public String getEmail() {
		return emailField.getValue();
	}

	public void setEmail(String email) {
		this.emailField.setValue(email);
	}
}
