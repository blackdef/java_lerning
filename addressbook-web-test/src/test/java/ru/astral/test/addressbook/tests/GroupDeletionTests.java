package ru.astral.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase{

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isthereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test2"));
        }
        List<GroupData> befor = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(befor.size() - 1);
        app.getGroupHelper().deleteSelectedGroup();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),befor.size() - 1);

        befor.remove(befor.size()-1);
        Assert.assertEquals(befor, after);

    }


}
