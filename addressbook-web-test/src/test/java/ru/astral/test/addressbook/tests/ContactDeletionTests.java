package ru.astral.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @Test
    public void ContactDeletionTests() throws InterruptedException {
        app.getNavigationHelper().gotoHomePage();
        if(! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test1", "test2", null, "test4", "test5", "test6", "test7", "123456", "89876543210"));
        }
        List<ContactData> befor = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(befor.size()-1);
        app.getContactHelper().deleteContact();
        //Thread.sleep(1000);
        app.getContactHelper().confirmDeletion();
        //Thread.sleep(2000);
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), befor.size() - 1);

        befor.remove(befor.size() - 1);
        Assert.assertEquals(after , befor);

    }


}
