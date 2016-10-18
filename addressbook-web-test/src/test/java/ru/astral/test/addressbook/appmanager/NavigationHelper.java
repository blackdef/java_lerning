package ru.astral.test.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Fedor on 14.10.2016.
 */
public class NavigationHelper extends HelperBase{


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Group")
            && isElementPresent(By.name("new"))){
      return;
    }
    click(By.linkText("groups"));
  }


  public void gotoHomePage() {
    if(isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home"));
  }
}
