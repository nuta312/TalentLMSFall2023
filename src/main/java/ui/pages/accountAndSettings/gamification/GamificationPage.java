package ui.pages.accountAndSettings.gamification;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class GamificationPage extends BasePage {

    @FindBy(xpath ="//label[@for='enable_gamification']")
    public WebElement gamificationSwitchButton;
    @FindBy(xpath = "//label[@for='enable_points']")
    public WebElement pointsSwitchButton;
    @FindBy(xpath = "//label[@for='enable_badges']")
    public WebElement badgesSwitchButton;
    @FindBy(xpath = "//label[@for='enable_levels']")
    public WebElement levelsSwitchButton;
    @FindBy (xpath = "//label[@for='enable_rewards']")
    public WebElement rewardsSwitchButton;
    @FindBy(xpath = "//label[@for='enable_leaderboard']")
    public WebElement leaderboardSwitchButton;
    @FindBy(xpath = "//input[contains(@name,'submit_gamification')]")
    public WebElement saveButton;
    @FindBy(xpath = "//a[contains(text(),'cancel')]")
    public WebElement cancelButton;
    @FindBy(xpath = "//*[@id='tl-reset-default-settings-button']")
    public WebElement resetToDefaultSettingsButton;
    @FindBy(xpath = "//*[@id='tl-reset-gamification-statistics-button']")
    public WebElement resetStatisticsButton;
    @FindBy(xpath = "//*[@id='tl-confirm-submit']")
    public WebElement windowResetButton;
    @FindBy(xpath = "(//ul[@class='select2-results'])[2]")
    public WebElement selectAllStatistics;
    @FindBy(xpath = "//*[@id='select2-drop'']/ul/li[2]/div")
    public WebElement selectPoints;
    @FindBy(xpath = "//div[@class='select2-result-label' and contains(text(),'Badges')]")
    public WebElement selectBadges;
    @FindBy(xpath = "//div[@class='select2-result-label' and contains(text(),'Levels')]")
    public WebElement selectLevels;
    @FindBy(xpath = "//div[text()='Gamification settings updated successfully']")
    public WebElement successUpdateMessage;

    public GamificationPage clickPointsSwitchButton() {
        webElementHelper.click(pointsSwitchButton);
        return this;
    }

    public GamificationPage clickGamificationSwitchButton() {
        webElementHelper.click(gamificationSwitchButton);
        return this;
    }

    public GamificationPage clickEnableBadgesSwitchButton() {
        webElementHelper.click(badgesSwitchButton);
        return this;
    }

    public GamificationPage clickEnableLevelsSwitchButton() {
        webElementHelper.click(levelsSwitchButton);
        return this;
    }

    public GamificationPage clickEnableRewardsSwitchButton() {
        webElementHelper.click(rewardsSwitchButton);
        return this;
    }

    public GamificationPage clickEnableLeaderboardSwitchButton() {
        webElementHelper.click(leaderboardSwitchButton);
        return this;
    }

    public GamificationPage clickSaveGamificationButton() {
        webElementHelper.click(saveButton);
        return this;
    }

    public GamificationPage clickCancelButton() {
        webElementHelper.click(cancelButton);
        return this;
    }

    public GamificationPage clickResetToDefaultButton() {
        webElementHelper.click(resetToDefaultSettingsButton);
        return this;
    }

    public GamificationPage clickResetStatisticsButton() {
        webElementHelper.click(resetStatisticsButton);
        return this;
    }

    public GamificationPage clickWindowResetButton() {
        webElementHelper.click(windowResetButton);
        return this;
    }

    public GamificationPage selectAllStatisticsButton() {
        webElementHelper.click(selectAllStatistics);
        return this;
    }

    public GamificationPage selectPointsButton() {
        webElementHelper.click(selectPoints);
        return this;
    }

    public GamificationPage selectBadgesButton() {
        webElementHelper.click(selectBadges);
        return this;
    }

    public GamificationPage selectLevelsButton() {
        webElementHelper.click(selectLevels);
        return this;
    }
}
