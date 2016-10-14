package ru.astral.test.addressbook;


import org.testng.annotations.Test;


public class GroupCreateTest  extends TestBase {

  @Test
    public void testGroupCreate() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("test1", "test2", "test2"));
        submitGroupCreation();
        returnToGroupPage();
    }


}
