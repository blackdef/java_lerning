package ru.astral.test.addressbook.tests;

import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.ContactData;

/**
 * Created by Fedor on 17.10.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initModification();
    app.getContactHelper().fillContactInfo(new ContactData("test10", "test20", "test30", "test40", "test50", "test60", "test70", "1234560", "898765432100"));
    app.getContactHelper().submitContactUpdate();
    app.getContactHelper().returnHomePage();
  }
}
