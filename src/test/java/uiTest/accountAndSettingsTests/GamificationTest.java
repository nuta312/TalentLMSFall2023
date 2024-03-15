package uiTest.accountAndSettingsTests;

import org.testng.annotations.Test;
import uiTest.BaseTest;

import static ui.pages.TalentLMS_PAGES.MY_DOMAIN;
import static ui.pages.TalentLMS_PAGES.TALENTLMS;
import static ui.pages.TalentLMS_PAGES.GAMIFICATION;
import static org.testng.Assert.assertEquals;

public class GamificationTest extends BaseTest {

    @Test(description = "Click all switch buttons")
    public void clickAllSwitchButtons() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + GAMIFICATION);
        gamificationPage.clickPointsSwitchButton()
                .clickEnableBadgesSwitchButton()
                .clickEnableLevelsSwitchButton();
        webElementHelper.scrollDownPage();
        gamificationPage.clickEnableRewardsSwitchButton()
                        .clickEnableLeaderboardSwitchButton();
        gamificationPage.clickSaveGamificationButton();
        assertEquals(gamificationPage.successUpdateMessage.getText(), "Gamification settings updated successfully");
    }

    @Test(description = "Click all 'Points' checkboxes")
    public void clickAllPointsCheckboxes() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + GAMIFICATION);
        pointsBox.clickEachLogin()
                .clickEachUnitCompletion()
                .clickEachCourseCompletion()
                .clickEachCertificate()
                .clickEachSuccessfulTest()
                .clickEachSuccessfulAssignment()
                .clickEachSuccessfulILT()
                .clickEachDiscussionTopicOrComment()
                .clickEachUpvoteOnDiscussionComments();
        gamificationPage.clickSaveGamificationButton();
        assertEquals(gamificationPage.successUpdateMessage.getText(), "Gamification settings updated successfully");
    }

    @Test(description = "Click all 'Badges' checkboxes")
    public void clickAllBadgesCheckboxes() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + GAMIFICATION);
        badgesBox.clickActivityBadges()
                .clickLearningBadges()
                .clickTestBadges()
                .clickAssignmentBadges()
                .clickPerfectionismBadges()
                .clickSurveyBadges()
                .clickCommunicationBadges()
                .clickCertificationBadges();
        gamificationPage.clickSaveGamificationButton();
        assertEquals(gamificationPage.successUpdateMessage.getText(), "Gamification settings updated successfully");
    }

    @Test(description = "Click all 'Levels' checkboxes")
    public void clickAllLevelsCheckboxes() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + GAMIFICATION);
        webElementHelper.scrollDownPage();
        levelsBox.clickUpgradeLevelPointsCheck()
                .clickUpgradeLevelCompletedCoursesCheck()
                .clickUpgradeLevelBadgesCheck();
        gamificationPage.clickSaveGamificationButton();
        assertEquals(gamificationPage.successUpdateMessage.getText(), "Gamification settings updated successfully");
    }

    @Test(description = "Click all 'Rewards' checkboxes")
    public void clickAllRewardsCheckboxes() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + GAMIFICATION);
        webElementHelper.scrollDownPage();
        rewardsBox.clickDiscountPointsCheck()
                .clickDiscountBadgesCheck()
                .clickDiscountLevelCheck();
        gamificationPage.clickSaveGamificationButton();
        assertEquals(gamificationPage.successUpdateMessage.getText(), "Gamification settings updated successfully");
    }

    @Test(description = "Click all 'Rewards' checkboxes")
    public void clickAllLeaderboardCheckboxes() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + GAMIFICATION);
        webElementHelper.scrollDownPage();
        leaderboardBox.clickLeaderboardLevels()
                .clickLeaderboardPoints()
                .clickLeaderboardBadges()
                .clickLeaderboardCourses()
                .clickLeaderboardCertifications();
        gamificationPage.clickSaveGamificationButton();
        assertEquals(gamificationPage.successUpdateMessage.getText(), "Gamification settings updated successfully");
    }
}
