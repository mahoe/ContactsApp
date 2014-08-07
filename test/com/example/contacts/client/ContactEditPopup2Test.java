package com.example.contacts.client;

import com.example.contacts.shared.Contact;
import org.junit.Assert;
import org.junit.Test;

public class ContactEditPopup2Test {

	@Test
    public void testExistingContact()
    {
        final Contact contact = new Contact();
		contact.setFirstName("Thomas");
		contact.setLastName("Mueller");
		contact.setEmailAddress("thomas.mueller@fcb.de");

		ContactEditPopupPresenter contactEditPresenter = new ContactEditPopupPresenter(contact);
		contactEditPresenter.setView(new ContactEditPopupInterface() {
			@Override
			public void show() {

			}

            @Override
            public void onSave()
            {

            }

            @Override
			public void setLastName(String lastName) {
				Assert.assertEquals("Mueller", lastName);
			}

			@Override
			public void setFirstName(String firstName) {
				Assert.assertEquals("Thomas", firstName);
			}

			@Override
			public void setEmail(String emailAddress) {
				Assert.assertEquals("thomas.mueller@fcb.de", emailAddress);
			}

			@Override
			public void hide() {

			}

			@Override
			public String getLastName() {
				Assert.fail();
				return null;
			}

            @Override
            public void addSaveHandler(SaveHandler handler)
            {

            }

            @Override
			public String getFirstName() {
				Assert.fail();
				return null;
			}

			@Override
			public String getEmail() {
				Assert.fail();
				return null;
			}
		});

		contactEditPresenter.init();
	}

    @Test
    public void testNewContact()
    {
        Contact contact = new Contact();
       ContactEditPopupPresenter presenter = new ContactEditPopupPresenter(contact);
        final ContactEditPopupInterface view = new ContactEditPopupInterface()
        {
            public SaveHandler handler;

            @Override
            public void addSaveHandler(SaveHandler handler)
            {
                this.handler = handler;
            }

            @Override
            public String getFirstName()
            {
                return "Tomas";
            }

            @Override
            public String getLastName()
            {
                return "Müller";
            }

            @Override
            public String getEmail()
            {
                return "to.mue@fdg.com";
            }

            @Override
            public void hide()
            {

            }

            @Override
            public void setFirstName(String firstName)
            {

            }

            @Override
            public void setLastName(String lastName)
            {

            }

            @Override
            public void setEmail(String emailAddress)
            {

            }

            @Override
            public void show()
            {

            }

            @Override
            public void onSave()
            {
                handler.onSave();
            }
        };
        presenter.setView(view);

        presenter.init();
        view.onSave();

        Assert.assertEquals("Tomas", contact.getFirstName());
        Assert.assertEquals("Müller", contact.getLastName());
        Assert.assertEquals("to.mue@fdg.com", contact.getEmailAddress());
    }
}
