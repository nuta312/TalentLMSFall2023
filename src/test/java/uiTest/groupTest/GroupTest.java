package uiTest.groupTest;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;

public class GroupTest extends BaseTest {

    @Test(groups = {"TLMS", "Regression", "UI", "126"}, priority = 1)
    @Tag("Regression")
    public void addGroupTest() {
        talentLmsInitPages.groupsPage.addGroup();
        assertEquals(talentLmsInitPages.groupsPage.messageAfterCreateGroup.getText(),"Success! New group created.");
        talentLmsInitPages.groupsPage.backToMainGroupPageList();
    }

    @Test(groups = {"TLMS", "Regression", "UI", "127"}, priority = 2)
    @Tag("Regression")
    public void updateGroupTest() {
        talentLmsInitPages.groupsPage.updateGroup();
        assertEquals(talentLmsInitPages.groupsPage.messageAfterUpdateGroup.getText(),"Success! Group updated.");
    }

    @Test(groups = {"TLMS", "Regression", "UI", "128"}, priority = 3)
    @Tag("Regression")
    public void deleteGroupTest() {
        talentLmsInitPages.groupsPage.deleteGroup();
    }
}