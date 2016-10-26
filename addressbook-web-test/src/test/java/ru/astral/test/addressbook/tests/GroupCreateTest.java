package ru.astral.test.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;


public class GroupCreateTest extends TestBase {

  @Test
  public void testGroupCreate() {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData("test1", "test2", "test2");
    app.group().create(group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(),before.size() + 1);

    //group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
    //Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));

  }


}
