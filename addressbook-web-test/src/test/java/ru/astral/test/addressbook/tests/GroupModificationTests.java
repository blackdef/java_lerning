package ru.astral.test.addressbook.tests;

import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.GroupData;

/**
 * Created by Fedor on 15.10.2016.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification(){
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isthereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test2"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test10", "test2", "test30"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }


}
