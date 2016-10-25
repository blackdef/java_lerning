package ru.astral.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

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
    List<GroupData> befor = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(befor.size() - 1);
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(befor.get(befor.size() - 1).getId(),"test10", "test2", "test30");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),befor.size());

    befor.remove(befor.size()-1);
    befor.add(group);

    Assert.assertEquals(new HashSet<Object>(befor), new HashSet<Object>(after));
  }


}
