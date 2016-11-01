package ru.astral.test.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Fedor on 01.11.2016.
 */
public class ContactInfoTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if(app.contact().all().size() == 0) {
      app.contact().create(new ContactData().
              withFirstName("test1").withLastName("test2").withAddress("test3").withCompany("test4").withAddress("test5").
              withMiddleName("test6").withNickName("test7").withTitle("test8").withHome("123456").withMobile("89876543210"));
    }
  }

  @Test(enabled = true)
  public void testContactPhone(){
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactFromEditForm)));

  }

  @Test
  public void testContactAddress(){
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(),equalTo(contactFromEditForm.getAddress()));
  }

  @Test
  public void testContactEmail(){
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getEmail(),equalTo(contactFromEditForm.getEmail()));
  }

  public static String  cleaned(String phone){
    return phone.replaceAll("\\s" , "").replaceAll("[-()]","");
  }

  public String mergePhones(ContactData contact){
        return Arrays.asList(contact.getHome(), contact.getMobile(), contact.getWork()).stream().filter((s) -> !s.equals(""))
            .map(ContactInfoTest::cleaned).collect(Collectors.joining("\n"));

  }
}
