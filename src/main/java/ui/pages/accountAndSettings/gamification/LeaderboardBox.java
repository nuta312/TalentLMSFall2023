package ui.pages.accountAndSettings.gamification;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeaderboardBox extends GamificationPage{

    @FindBy(xpath = "//input[contains(@name,'leaderboard_levels')]")
    public WebElement leaderboardLevels;
    @FindBy(xpath = "//input[contains(@name,'leaderboard_points')]")
    public WebElement leaderboardPoints;
    @FindBy(xpath = "//input[contains(@name,'leaderboard_badges')]")
    public WebElement leaderboardBadges;
    @FindBy(xpath = "//input[contains(@name,'leaderboard_courses')]")
    public WebElement leaderboardCourses;
    @FindBy(xpath = "//input[contains(@name,'leaderboard_certifications')]")
    public WebElement leaderboardCertifications;

    public LeaderboardBox clickLeaderboardLevels() {
        webElementHelper.click(leaderboardLevels);
        return this;
    }

    public LeaderboardBox clickLeaderboardPoints() {
        webElementHelper.click(leaderboardPoints);
        return this;
    }

    public LeaderboardBox clickLeaderboardBadges() {
        webElementHelper.click(leaderboardBadges);
        return this;
    }

    public LeaderboardBox clickLeaderboardCourses() {
        webElementHelper.click(leaderboardCourses);
        return this;
    }

    public LeaderboardBox clickLeaderboardCertifications() {
        webElementHelper.click(leaderboardCertifications);
        return this;
    }
}
