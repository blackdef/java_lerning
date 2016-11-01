package ru.astral.test.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.GroupData;
import ru.astral.test.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Fedor on 15.10.2016.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0){
      app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test2"));
    }
  }

  @Test
  public void testGroupModification(){
    Groups before = app.group().all();
    GroupData modifyGroup = before.iterator().next();

    GroupData group = new GroupData().withId(modifyGroup.getId()).withName("test1").withHeader("test2").withFooter("test2");
    app.group().modify(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.without(modifyGroup).withAdded(group)));


  }




}
