package ru.astral.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase{

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isthereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test2"));
        }
        int befor = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroup();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,befor - 1);
    }


}
