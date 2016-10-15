package ru.astral.test.addressbook.tests;

import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import ru.astral.test.addressbook.model.ContactData;

public class CreateContactTests extends TestBase{

    @Test
    public void testCreateContact() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactInfo(new ContactData("test1", "test2", "test3", "test4", "test5", "test6", "test7", "123456", "89876543210"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnHomePage();
    }
}
