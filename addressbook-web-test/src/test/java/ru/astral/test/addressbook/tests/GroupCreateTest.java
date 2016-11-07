package ru.astral.test.addressbook.tests;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.GroupData;
import ru.astral.test.addressbook.model.Groups;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreateTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups(){
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
    list.add(new Object[] {new GroupData().withName("test2").withHeader("header2").withFooter("footer2")});
    list.add(new Object[] {new GroupData().withName("test3").withHeader("header3").withFooter("footer3")});
    list.add(new Object[] {new GroupData().withName("test4").withHeader("header4").withFooter("footer4")});
    return list.iterator();
  }

  @Test(enabled = true, dataProvider = "validGroups")
  public void testGroupCreate(GroupData group) {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()+1));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


  }

  @Test(enabled = false)
  public void testBadGroupCreate() {
    app.goTo().groupPage();
    Groups before = app.group().all();

    GroupData group = new GroupData().withName("test1'").withHeader("test2").withFooter("test2");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));


  }


}
