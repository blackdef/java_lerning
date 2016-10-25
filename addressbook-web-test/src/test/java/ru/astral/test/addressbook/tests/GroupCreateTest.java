package ru.astral.test.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.GroupData;

import java.util.List;


public class GroupCreateTest extends TestBase {

  @Test
  public void testGroupCreate() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> befor = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test2"));
    List<GroupData> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(),befor.size() + 1);
  }


}
