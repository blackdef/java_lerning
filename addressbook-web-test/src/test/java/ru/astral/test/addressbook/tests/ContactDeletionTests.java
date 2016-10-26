package ru.astral.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @Test(enabled = false)
    public void ContactDeletionTests() throws InterruptedException {
        app.goTo().gotoHomePage();
        if(! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test1", "test2", null, "test4", "test5", "test6", "test7", "123456", "89876543210"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().deleteContact();
        //Thread.sleep(1000);
        app.getContactHelper().confirmDeletion();
        //Thread.sleep(2000);
        app.goTo().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(after , before);

    }


}
