package uiTest.AccountAndSettingsTests;

import org.testng.annotations.Test;
import uiTest.BaseTest;
import static org.testng.Assert.assertEquals;
import static pages.TalentLMS_PAGES.GAMIFICATION;

public class GamificationTest extends BaseTest {

    @Test(description = "Click all switch buttons")
    public void clickAllSwitchButtons(){
        browserManager.openByNavigate(GAMIFICATION.toString());
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
    public void clickAllPointsCheckboxes(){
        browserManager.openByNavigate(GAMIFICATION.toString());
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
    public void clickAllBadgesCheckboxes(){
        browserManager.openByNavigate(GAMIFICATION.toString());
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
    public void clickAllLevelsCheckboxes(){
        browserManager.openByNavigate(GAMIFICATION.toString());
        webElementHelper.scrollDownPage();
        levelsBox.clickUpgradeLevelPointsCheck()
                .clickUpgradeLevelCompletedCoursesCheck()
                .clickUpgradeLevelBadgesCheck();
        gamificationPage.clickSaveGamificationButton();
        assertEquals(gamificationPage.successUpdateMessage.getText(), "Gamification settings updated successfully");
    }

    @Test(description = "Click all 'Rewards' checkboxes")
    public void clickAllRewardsCheckboxes(){
        browserManager.openByNavigate(GAMIFICATION.toString());
        webElementHelper.scrollDownPage();
        rewardsBox.clickDiscountPointsCheck()
                .clickDiscountBadgesCheck()
                .clickDiscountLevelCheck();
        gamificationPage.clickSaveGamificationButton();
        assertEquals(gamificationPage.successUpdateMessage.getText(), "Gamification settings updated successfully");
    }

    @Test(description = "Click all 'Rewards' checkboxes")
    public void clickAllLeaderboardCheckboxes(){
        browserManager.openByNavigate(GAMIFICATION.toString());
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
