package ui.pages.reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class UsersUnderReportsPage extends BasePage {

    @FindBy(xpath = "(//div/a[contains(text(),'Users')])[2]")
    public WebElement usersLink;
    @FindBy(xpath = "//td/a/span[contains(text(),'Bekeshev Nurzat')]")
    public WebElement userInfo;
    @FindBy(xpath = "//h3/span[@title='Bekeshev Nurzat']")
    public WebElement userData;
    @FindBy(xpath = "//div/a[contains(text(),'Today')]")
    public WebElement toDay;
    @FindBy(xpath = "//div/a[contains(text(),'Yesterday')]")
    public WebElement yesterDay;
    @FindBy(xpath = "//div/a[contains(text(),'Week')]")
    public WebElement week;
    @FindBy(xpath = "//div/a[contains(text(),'Month')]")
    public WebElement month;
    @FindBy(xpath = "//div/a[contains(text(),'Year')]")
    public WebElement year;
    @FindBy(xpath = "//div/a[contains(text(),'Period')]")
    public WebElement period;
    @FindBy(id = "tl-report-period-from")
    public WebElement from;
    @FindBy(xpath = "(//td[@class='day '])[1]")
    public WebElement getToday;
    @FindBy(xpath = "(//tr/td[@class='day  active'])[2]")
    public WebElement getActiveToday;
    @FindBy(id = "tl-report-period-to")
    public WebElement to;
    @FindBy(id = "tl-report-period-submit")
    public WebElement show;
    @FindBy(xpath = "(//div[@class='pull-right'])[1]")
    public WebElement viewInfographic;
    @FindBy(xpath = "//div[contains(text(),'Training infographic')]")
    public WebElement infographicText;
    @FindBy(xpath = "(//div[@class='pull-right'])[2]")
    public WebElement viewAllBadges;
    @FindBy(id = "overview-tab")
    public WebElement overViewTab;
    @FindBy(id = "trigger-gamification-modal")
    public WebElement gamification;
    @FindBy(id = "tl-howto-collect-points")
    public WebElement howToCollectPoints;
    @FindBy(id = "tl-widget-goback")
    public WebElement back;
    @FindBy(id = "levels-row")
    public WebElement levels;
    @FindBy(id = "tl-howto-upgrade-level")
    public WebElement howToLevelUp;
    @FindBy(id = "badges-row")
    public WebElement badges;
    @FindBy(id = "tl-goto-badges-leaderboard")
    public WebElement myBadgeCollection;
    @FindBy(xpath = "(//a[@class='close'])[11]")
    public WebElement close;

    public UsersUnderReportsPage clickToday() {
        webElementHelper.click(toDay);
        return this;
    }

    public UsersUnderReportsPage clickYesterday() {
        webElementHelper.click(yesterDay);
        return this;
    }

    public UsersUnderReportsPage clickWeek() {
        webElementHelper.click(week);
        return this;
    }

    public UsersUnderReportsPage clickMonth() {
        webElementHelper.click(month);
        return this;
    }

    public UsersUnderReportsPage clickYear() {
        webElementHelper.click(year);
        return this;
    }

    public UsersUnderReportsPage clickPeriod() {
        webElementHelper.click(period);
        return this;
    }

    public UsersUnderReportsPage clickFrom() {
        webElementHelper.click(from);
        webElementHelper.click(getToday);
        return this;

    }

    public UsersUnderReportsPage clickTo() {
        webElementHelper.click(to);
        webElementHelper.click(getActiveToday);
        return this;

    }

    public UsersUnderReportsPage clickShow() {
        webElementHelper.click(show);
        return this;
    }

    public UsersUnderReportsPage clickViewInfographic() {
        webElementHelper.click(viewInfographic);
        return this;
    }

    public UsersUnderReportsPage clickViewAllBadges() {
        webElementHelper.click(viewAllBadges);
        return this;
    }

    public UsersUnderReportsPage clickOverViewTab() {
        webElementHelper.click(overViewTab);
        return this;
    }

    public UsersUnderReportsPage clickGamification() {
        webElementHelper.click(gamification);
        return this;
    }

    public UsersUnderReportsPage clickHowToCollPoints() {
        webElementHelper.click(howToCollectPoints);
        return this;
    }

    public UsersUnderReportsPage clickBackTab() {
        webElementHelper.click(back);
        return this;
    }

    public UsersUnderReportsPage clickLevels() {
        webElementHelper.click(levels);
        return this;
    }

    public UsersUnderReportsPage clickHowToLevelUp() {
        webElementHelper.click(howToLevelUp);
        return this;
    }

    public UsersUnderReportsPage clickBadges() {
        webElementHelper.click(badges);
        return this;
    }

    public UsersUnderReportsPage clickMyBadgeCollection() {
        webElementHelper.click(myBadgeCollection);
        return this;
    }

    public UsersUnderReportsPage clickClose() {
        webElementHelper.click(close);
        return this;
    }
}
