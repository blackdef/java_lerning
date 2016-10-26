package ru.astral.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Fedor on 15.10.2016.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0){
      app.group().create(new GroupData("test1", "test2", "test2"));
    }
  }

  @Test
  public void testGroupModification(){
    List<GroupData> before = app.group().list();
    int index = before.size()-1;
    GroupData group = new GroupData(before.get(index).getId(),"test10", "test2", "test30");
    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(),before.size());

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }




}
