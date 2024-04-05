package uiTest.accountAndSettingsTests;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static ui.pages.TalentLMS_PAGES.MY_DOMAIN;
import static ui.pages.TalentLMS_PAGES.TALENTLMS;
import static ui.pages.TalentLMS_PAGES.GAMIFICATION;
import static org.testng.Assert.assertEquals;

public class GamificationTest extends BaseTest {

    @Test(description = "Click all switch buttons", groups = {"TLMS", "Regression", "UI", "106"})
    @Tag("Regression")
    public void clickAllSwitchButtons() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + GAMIFICATION.getURL());
        talentLmsInitPages.gamificationPage.clickPointsSwitchButton()
                .clickEnableBadgesSwitchButton()
                .clickEnableLevelsSwitchButton();
        webElementHelper.scrollDownPage();
        talentLmsInitPages.gamificationPage.clickEnableRewardsSwitchButton()
                        .clickEnableLeaderboardSwitchButton();
        talentLmsInitPages.gamificationPage.clickSaveGamificationButton();
        assertEquals(talentLmsInitPages.gamificationPage.successUpdateMessage.getText(), "Gamification settings updated successfully");
    }

    @Test(description = "Click all 'Points' checkboxes", groups = {"TLMS", "Regression", "UI", "107"})
    @Tag("Regression")
    public void clickAllPointsCheckboxes() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + GAMIFICATION.getURL());
        talentLmsInitPages.pointsBox.clickEachLogin()
                .clickEachUnitCompletion()
                .clickEachCourseCompletion()
                .clickEachCertificate()
                .clickEachSuccessfulTest()
                .clickEachSuccessfulAssignment()
                .clickEachSuccessfulILT()
                .clickEachDiscussionTopicOrComment()
                .clickEachUpvoteOnDiscussionComments();
        talentLmsInitPages.gamificationPage.clickSaveGamificationButton();
        assertEquals(talentLmsInitPages.gamificationPage.successUpdateMessage.getText(), "Gamification settings updated successfully");
    }

    @Test(description = "Click all 'Badges' checkboxes", groups = {"TLMS", "Regression", "UI", "108"})
    @Tag("Regression")
    public void clickAllBadgesCheckboxes() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + GAMIFICATION.getURL());
        talentLmsInitPages.badgesBox.clickActivityBadges()
                .clickLearningBadges()
                .clickTestBadges()
                .clickAssignmentBadges()
                .clickPerfectionismBadges()
                .clickSurveyBadges()
                .clickCommunicationBadges()
                .clickCertificationBadges();
        talentLmsInitPages.gamificationPage.clickSaveGamificationButton();
        assertEquals(talentLmsInitPages.gamificationPage.successUpdateMessage.getText(), "Gamification settings updated successfully");
    }

    @Test(description = "Click all 'Levels' checkboxes", groups = {"TLMS", "Regression", "UI", "109"})
    @Tag("Regression")
    public void clickAllLevelsCheckboxes() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + GAMIFICATION.getURL());
        webElementHelper.scrollDownPage();
        talentLmsInitPages.levelsBox.clickUpgradeLevelPointsCheck()
                .clickUpgradeLevelCompletedCoursesCheck()
                .clickUpgradeLevelBadgesCheck();
        talentLmsInitPages.gamificationPage.clickSaveGamificationButton();
        assertEquals(talentLmsInitPages.gamificationPage.successUpdateMessage.getText(), "Gamification settings updated successfully");
    }

    @Test(description = "Click all 'Rewards' checkboxes", groups = {"TLMS", "Regression", "UI", "110"})
    @Tag("Regression")
    public void clickAllRewardsCheckboxes() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + GAMIFICATION.getURL());
        webElementHelper.scrollDownPage();
        talentLmsInitPages.rewardsBox.clickDiscountPointsCheck()
                .clickDiscountBadgesCheck()
                .clickDiscountLevelCheck();
        talentLmsInitPages.gamificationPage.clickSaveGamificationButton();
        assertEquals(talentLmsInitPages.gamificationPage.successUpdateMessage.getText(), "Gamification settings updated successfully");
    }

    @Test(description = "Click all 'Leaderboard' checkboxes", groups = {"TLMS", "Regression", "UI", "111"})
    @Tag("Regression")
    public void clickAllLeaderboardCheckboxes() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + GAMIFICATION.getURL());
        webElementHelper.scrollDownPage();
        talentLmsInitPages.leaderboardBox.clickLeaderboardLevels()
                .clickLeaderboardPoints()
                .clickLeaderboardBadges()
                .clickLeaderboardCourses()
                .clickLeaderboardCertifications();
        talentLmsInitPages.gamificationPage.clickSaveGamificationButton();
        assertEquals(talentLmsInitPages.gamificationPage.successUpdateMessage.getText(), "Gamification settings updated successfully");
    }
}
