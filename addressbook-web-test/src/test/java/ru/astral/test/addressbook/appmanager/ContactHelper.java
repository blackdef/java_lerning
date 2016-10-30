package ru.astral.test.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.astral.test.addressbook.model.ContactData;
import ru.astral.test.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Fedor on 16.10.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void returnHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactInfo(ContactData contactData) {

    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());

  }


  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));

  }

  public void confirmDeletion() {
    wd.switchTo().alert().accept();
  }

  public void delete(ContactData deleteContact) throws InterruptedException {
    selectContactById(deleteContact);
    deleteContact();
    confirmDeletion();
    Thread.sleep(2000);
  }

  public void selectContact(int index) {
    WebElement element = wd.findElements(By.name("selected[]")).get(index);
    if (!element.isSelected()) {
      element.click();
    }

  }

  public void selectContactById(ContactData contact) {
    WebElement element = wd.findElement(By.cssSelector("input[id = '" + contact.getId() + "']"));
    if (!element.isSelected()) {
      element.click();
    }

  }


  public void initModification(int index) {
    wd.findElements(By.cssSelector("tr")).get(index + 1).findElements(By.cssSelector("td")).get(7).click();
  }

  public void submitContactUpdate() {
    click(By.name("update"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactInfo(contact);
    submitContactCreation();
    returnHomePage();
  }


  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
    rows.remove(0);
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.cssSelector("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstName(firstname).withLastName(lastname).withAddress(address);
      contacts.add(contact);
    }
    return contacts;
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> rows = wd.findElements(By.cssSelector("table[id = 'maintable']>tbody>tr"));
    rows.remove(0);
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.cssSelector("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname).withAddress(address));
    }
    return contacts;
  }
}
