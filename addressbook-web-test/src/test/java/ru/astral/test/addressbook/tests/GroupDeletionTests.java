package ru.astral.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.astral.test.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0){
            app.group().create(new GroupData("test1", "test2", "test2"));
        }
    }

    @Test
    public void testGroupDeletion() {
        app.goTo().groupPage();
        if (!app.group().isthereAGroup()){
            app.group().create(new GroupData("test1", "test2", "test2"));
        }
        List<GroupData> befor = app.group().list();
        int index = befor.size() - 1;
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(),befor.size() - 1);

        befor.remove(index);
        Assert.assertEquals(befor, after);

    }



}
