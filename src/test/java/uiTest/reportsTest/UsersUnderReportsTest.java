package uiTest.reportsTest;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;

public class UsersUnderReportsTest extends BaseTest {

    @Test(description = "This method clicks on the Users link, then clicks on a user and\n" +
            "displays  information about that user", groups = {"TLMS", "Regression", "UI", "146"})
    @Tag("Regression")
    public void clickUsersUnderReports() {
        talentLmsInitPages.reportsIconAndLinkPage.clickLinkUnderReports(talentLmsInitPages.usersUnderReportsPage.usersLink);
        talentLmsInitPages.reportsIconAndLinkPage.clickToUser(talentLmsInitPages.usersUnderReportsPage.userInfo);
        assertEquals(talentLmsInitPages.usersUnderReportsPage.userData.getText(),"Nomad Digital");
        talentLmsInitPages.usersUnderReportsPage.clickToday()
                .clickYesterday()
                .clickWeek()
                .clickMonth()
                .clickYear()
                .clickPeriod()
                .clickFrom()
                .clickTo()
                .clickShow()
                .clickViewInfographic();
        assertEquals(talentLmsInitPages.usersUnderReportsPage.infographicText.getText(),"Training infographic");
        browserManager.goBack();
        talentLmsInitPages.usersUnderReportsPage.clickViewAllBadges()
                .clickOverViewTab()
                .clickGamification()
                .clickHowToCollPoints()
                .clickBackTab()
                .clickLevels()
                .clickHowToLevelUp()
                .clickBackTab()
                .clickBadges()
                .clickMyBadgeCollection()
                .clickClose();
    }
}