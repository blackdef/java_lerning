package ru.astral.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.GroupData;

import java.util.Comparator;
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
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    befor.sort(byId);
    after.sort(byId);
    Assert.assertEquals(befor, after);
  }


}
