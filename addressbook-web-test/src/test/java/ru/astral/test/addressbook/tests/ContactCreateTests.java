package ru.astral.test.addressbook.tests;

import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.ContactData;
import ru.astral.test.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactCreateTests extends TestBase {

  @Test(enabled = true)
  public void testCreateContact() {
    app.goTo().gotoHomePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().
            withFirstName("test1").withLastName("test2").withAddress("test3").withCompany("test4").withAddress("test5").
            withMiddleName("test6").withNickName("test7").withTitle("test8").withHome("123456").withMobile("89876543210");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() + 1);
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }
}
