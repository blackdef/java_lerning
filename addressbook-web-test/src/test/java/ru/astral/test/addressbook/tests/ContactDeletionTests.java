package ru.astral.test.addressbook.tests;

import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

    @Test
    public void ContactDeletionTests() throws InterruptedException {
        app.getNavigationHelper().gotoHomePage();
        if(! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test1", "test2", null, "test4", "test5", "test6", "test7", "123456", "89876543210"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        //Thread.sleep(1000);
        app.getContactHelper().confirmDeletion();
        Thread.sleep(2000);

    }


}
