package ru.astral.test.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.ContactData;
import ru.astral.test.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class ContactDeletionTests extends TestBase{
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
    public void ContactDeletionTests() throws InterruptedException {

        Contacts before = app.contact().all();
        ContactData deleteContact = before.iterator().next();
        app.contact().delete(deleteContact);
        app.goTo().homePage();
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deleteContact)));

    }




}
