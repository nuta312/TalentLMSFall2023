package uiTest.groupTest;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;

@Tag("Smoke")
public class GroupTest extends BaseTest {

    @Test(priority = 1)
    void addGroupTest(){
        groupsPage.addGroup();
        assertEquals(groupsPage.messageAfterCreateGroup.getText(),"Success! New group created.");
        groupsPage.backToMainGroupPageList();
    }
    @Test(priority = 2)
    void updateGroupTest(){
        groupsPage.updateGroup();
        assertEquals(groupsPage.messageAfterUpdateGroup.getText(),"Success! Group updated.");
    }
    @Test(priority = 3)
    void deleteGroupTest(){
        groupsPage.deleteGroup();
    }
}