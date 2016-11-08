package ru.astral.test.addressbook.tests;

import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.ContactData;
import ru.astral.test.addressbook.model.Contacts;


import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactCreateTests extends TestBase {

  @Test(enabled = true)
  public void testCreateContact() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.gif");
    ContactData contact = new ContactData().
            withFirstName("test1").withLastName("test2").withAddress("test3").withCompany("test4").withAddress("test5").
            withMiddleName("test6").withNickName("test7").withTitle("test8").withHome("123456").withMobile("89876543210")
            .withPhoto(photo);
    app.contact().create(contact);
    assertEquals(app.contact().count(), before.size() + 1);
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }
  @Test(enabled = true)
  public void testCreateBadContact() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.gif");
    ContactData contact = new ContactData().
            withFirstName("test1'").withLastName("test2").withAddress("test3").withCompany("test4").withAddress("test5").
            withMiddleName("test6").withNickName("test7").withTitle("test8").withHome("123456").withMobile("89876543210")
            .withPhoto(photo);
    app.contact().create(contact);
    assertEquals(app.contact().count(), before.size());
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

  @Test
  public void testPathFile() {
    File currentDir = new File("src/test/resources/stru.gif");
    System.out.println(currentDir.getAbsolutePath());
    System.out.println(currentDir.exists());
  }
}
