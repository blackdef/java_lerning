package ru.astral.test.addressbook.tests;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.GroupData;
import ru.astral.test.addressbook.model.Groups;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreateTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));

    String line = reader.readLine();
    while(line != null){
      String[] split = line.split(";");
      list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
      line = reader.readLine();

    }
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
