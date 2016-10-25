package ru.astral.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Fedor on 17.10.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if(! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", "test2", null, "test4", "test5", "test6", "test7", "123456", "89876543210"));
    }
    List<ContactData> befor = app.getContactHelper().getContactList();
    app.getContactHelper().initModification(befor.size()-1);
    ContactData contact = new ContactData(befor.get(befor.size()-1).getId(),"test10", "test20", "test30", "test40", "test50", "test60", "test70", "1234560", "898765432100");
    app.getContactHelper().fillContactInfo(contact);
    app.getContactHelper().submitContactUpdate();
    app.getContactHelper().returnHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),befor.size());

    befor.remove(befor.size()-1);
    befor.add(contact);
    Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(befor));

  }
}
