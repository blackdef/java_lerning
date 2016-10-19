package ru.astral.test.addressbook.tests;


import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.GroupData;


public class GroupCreateTest  extends TestBase {

  @Test
    public void testGroupCreate() {
        app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test2"));

    }


}
