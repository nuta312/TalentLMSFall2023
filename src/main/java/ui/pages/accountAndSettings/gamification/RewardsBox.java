package ui.pages.accountAndSettings.gamification;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RewardsBox extends GamificationPage {

    @FindBy(xpath = "//input[contains(@name,'discount_points_check')]")
    public WebElement discountPointsCheck;
    @FindBy (xpath = "//input[contains(@name,'discount_points_percentage')]")
    public WebElement inputDiscountPointsPercentage;
    @FindBy (xpath = "//input[contains(@name,'discount_points_value')]")
    public WebElement inputDiscountPointsValue;
    @FindBy (xpath = "//input[contains(@name,'discount_badges_check')]")
    public WebElement discountBadgesCheck;
    @FindBy (xpath = "//input[contains(@name,'discount_badges_percentage')]")
    public WebElement inputDiscountBadgesPercentage;
    @FindBy (xpath = "//input[contains(@name,'discount_badges_value')]")
    public WebElement inputDiscountBadgesValue;
    @FindBy (xpath = "//input[contains(@name,'discount_level_check')]")
    public WebElement discountLevelCheck;
    @FindBy (xpath = "//input[contains(@name,'discount_level_percentage')]")
    public WebElement inputDiscountLevelPercentage;
    @FindBy (xpath = "//input[contains(@name,'discount_level_value')]")
    public WebElement inputDiscountLevelValue;

    public RewardsBox clickDiscountPointsCheck() {
        webElementHelper.click(discountPointsCheck);
        return this;
    }

    public RewardsBox inputDiscountPointsPercentage(String points) {
        webElementHelper.sendKeys(inputDiscountPointsPercentage, points);
        return this;
    }

    public RewardsBox inputDiscountPointsValue(String points) {
        webElementHelper.sendKeys(inputDiscountPointsValue, points);
        return this;
    }

    public RewardsBox clickDiscountBadgesCheck() {
        webElementHelper.click(discountBadgesCheck);
        return this;
    }

    public RewardsBox inputDiscountBadgesPercentage(String points) {
        webElementHelper.sendKeys(inputDiscountBadgesPercentage, points);
        return this;
    }

    public RewardsBox inputDiscountBadgesValue(String points) {
        webElementHelper.sendKeys(inputDiscountBadgesValue, points);
        return this;
    }

    public RewardsBox clickDiscountLevelCheck() {
        webElementHelper.click(discountLevelCheck);
        return this;
    }

    public RewardsBox inputDiscountLevelPercentage(String points) {
        webElementHelper.sendKeys(inputDiscountLevelPercentage, points);
        return this;
    }

    public RewardsBox inputDiscountLevelValue(String points) {
        webElementHelper.sendKeys(inputDiscountLevelValue, points);
        return this;
    }
}
