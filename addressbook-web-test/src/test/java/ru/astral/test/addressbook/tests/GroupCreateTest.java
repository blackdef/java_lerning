package ru.astral.test.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.ContactData;
import ru.astral.test.addressbook.model.GroupData;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class GroupCreateTest extends TestBase {

  @Test
  public void testGroupCreate() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> befor = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test1", "test2", "test2");
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),befor.size() + 1);


    int max = 0;
    for (GroupData g : after){
      if (max < g.getId()){
        max = g.getId();
      }
    }
    group.setId(max);
    befor.add(group);
    Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(befor));

  }


}
