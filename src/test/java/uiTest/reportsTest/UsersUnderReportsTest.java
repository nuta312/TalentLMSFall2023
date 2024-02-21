package uiTest.reportsTest;

import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;

public class UsersUnderReportsTest extends BaseTest {
    @Test(description = "This method clicks on the Users link, then clicks on a user and\n" +
            "displays  information about that user")
    void clickUsersUnderReports(){
        reportsIconAndLinkPage.clickLinkUnderReports(usersUnderReportsPage.usersLink);
        reportsIconAndLinkPage.clickToUser(usersUnderReportsPage.userInfo);
        assertEquals(usersUnderReportsPage.userData.getText(),"Bekeshev Nurzat");
        usersUnderReportsPage.clickToday()
                .clickYesterday()
                .clickWeek()
                .clickMonth()
                .clickYear()
                .clickPeriod()
                .clickFrom()
                .clickTo()
                .clickShow()
                .clickViewInfographic();
        assertEquals(usersUnderReportsPage.infographicText.getText(),"Training infographic");
        browserManager.goBack();
        usersUnderReportsPage.clickViewAllBadges()
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