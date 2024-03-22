package ui.pages.accountAndSettings.gamification;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LevelsBox extends GamificationPage {

    @FindBy(xpath = "//input[contains(@name,'upgrade_level_points_check')]")
    public WebElement upgradeLevelPointsCheck;
    @FindBy(xpath = "//input[contains(@name,'upgrade_level_points') and @class='span1 tl-gamification-engine-levels']")
    public WebElement inputUpgradeLevelEveryPoints;
    @FindBy(xpath = "//input[contains(@name,'upgrade_level_completed_courses_check')]")
    public WebElement upgradeLevelCompletedCoursesCheck;
    @FindBy(xpath = "//input[contains(@name,'upgrade_level_completed_courses') and @class='span1 tl-gamification-engine-levels']")
    public WebElement inputUpgradeLevelEveryCompletedCourses;
    @FindBy(xpath = "//input[contains(@name,'upgrade_level_badges_check')]")
    public WebElement upgradeLevelBadgesCheck;
    @FindBy(xpath = "//input[contains(@name,'upgrade_level_badges') and @class='tl-gamification-engine-levels']")
    public WebElement inputUpgradeLevelEveryBadges;

    public LevelsBox clickUpgradeLevelPointsCheck() {
        webElementHelper.click(upgradeLevelPointsCheck);
        return this;
    }

    public LevelsBox inputUpgradeLevelEveryPoints(String points) {
        webElementHelper.sendKeys(inputUpgradeLevelEveryPoints, points);
        return this;
    }

    public LevelsBox clickUpgradeLevelCompletedCoursesCheck() {
        webElementHelper.click(upgradeLevelCompletedCoursesCheck);
        return this;
    }

    public LevelsBox inputUpgradeLevelEveryCompletedCourses(String points) {
        webElementHelper.sendKeys(inputUpgradeLevelEveryCompletedCourses, points);
        return this;
    }

    public LevelsBox clickUpgradeLevelBadgesCheck() {
        webElementHelper.click(upgradeLevelBadgesCheck);
        return this;
    }

    public LevelsBox inputUpgradeLevelEveryBadges(String points) {
        webElementHelper.sendKeys(inputUpgradeLevelEveryBadges, points);
        return this;
    }
}
