package ru.astral.test.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Fedor on 14.10.2016.
 */
public class SessionHelper extends HelperBase{

  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void login(String userName, String password) {
    wd.get("http://localhost/addressbook/");

    type(By.name("user"),userName);
    type(By.name("pass"),password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));

  }
}
