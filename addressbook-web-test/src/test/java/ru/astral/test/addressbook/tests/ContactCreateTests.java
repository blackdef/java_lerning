package ru.astral.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreateTests extends TestBase {

  @Test(enabled = false)
  public void testCreateContact() {
    app.goTo().gotoHomePage();
    List<ContactData> befor = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("test1", "test2", "", "test4", "test5", "test6", "test7", "123456", "89876543210");
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), befor.size() + 1);

    //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    befor.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId()) ;
    befor.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, befor);
  }
}
