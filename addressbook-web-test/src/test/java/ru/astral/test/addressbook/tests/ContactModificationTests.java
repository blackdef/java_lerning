package ru.astral.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.ContactData;
import ru.astral.test.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Fedor on 17.10.2016.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().gotoHomePage();
    if(app.contact().all().size() == 0) {
      app.contact().create(new ContactData().
              withFirstName("test1").withLastName("test2").withAddress("test3").withCompany("test4").withAddress("test5").
              withMiddleName("test6").withNickName("test7").withTitle("test8").withHome("123456").withMobile("89876543210"));
    }
  }


  @Test(enabled = false)
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifyContact ;
    app.contact().initModification(before.size()-1);
    ContactData contact = new ContactData();
    //before.get(before.size()-1).getId(),"test10", "test20", "test30", "test40", "test50", "test60", "test70", "1234560", "898765432100");
    app.contact().fillContactInfo(contact);
    app.contact().submitContactUpdate();
    app.contact().returnHomePage();
    List<ContactData> after = app.contact().getContactList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size()-1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId()) ;

    Assert.assertEquals(after, before);

  }
}
