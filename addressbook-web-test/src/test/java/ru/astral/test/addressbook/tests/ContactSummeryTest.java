package ru.astral.test.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Fedor on 02.11.2016.
 */
public class ContactSummeryTest extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if(app.contact().all().size() == 0) {
      app.contact().create(new ContactData().
              withFirstName("test1").withLastName("test2").withAddress("test3").withCompany("test4").withAddress("test5").
              withMiddleName("test6").withNickName("test7").withTitle("test8").withHome("123456").withMobile("89876543210"));
    }
  }

  @Test
  public void testContactSummery(){
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactFromEditForm = app.contact().infoFromEditForm(contact);

    app.contact().goToSummery(contact);
    assertThat(app.contact().getAllInfo(), equalTo(mergeAllInfo(contactFromEditForm)));

  }

  private String mergeAllInfo(ContactData contact) {
    String result = Arrays.asList(contact.getFirstName(), contact.getMiddleName(),contact.getLastName())
            .stream().filter((s) -> !s.equals("")).collect(Collectors.joining(" "));
    if(!contact.getFirstName().equals("") || !contact.getMiddleName().equals("") || !contact.getLastName().equals("") )
      result +=  "\n";
    result += Arrays.asList(contact.getNickName(), contact.getTitle(), contact.getCompany(), contact.getAddress())
            .stream().filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));
    if (!contact.getNickName().equals("") || !contact.getTitle().equals("") ||
            !contact.getCompany().equals("") || !contact.getAddress().equals("") )
      result += "\n";
    if(!contact.getHome().equals("") || !contact.getMobile().equals("") || !contact.getWork().equals("") || !contact.getFax().equals(""))
      result += "\n";
    if (!contact.getHome().equals("")) result += "H: " + contact.getHome() + "\n";
    if (!contact.getMobile().equals("")) result += "M: " + contact.getMobile() + "\n";
    if (!contact.getWork().equals("")) result += "W: " + contact.getWork() + "\n";
    if (!contact.getFax().equals("")) result += "F: " + contact.getFax() + "\n";
    if (!contact.getEmail().equals(""))
       result += "\n"+contact.getEmail()+ " (www." + contact.getEmail().split("[@]")[1]+ ")";
    if(!contact.getHomepage().equals(""))
       result += "\nHomepage:\n"+ contact.getHomepage();
    if(!contact.getHomepage().equals("") || !contact.getEmail().equals(""))
      result += "\n";
    if (!contact.getAddress2().equals(""))
      result += "\n\n"+contact.getAddress2();
    if (!contact.getPhone2().equals(""))
      result += "\n\nP: "+contact.getPhone2();
    if (!contact.getNotes().equals(""))
      result += "\n\n"+contact.getNotes();



    return result;
  }
  //public

}

