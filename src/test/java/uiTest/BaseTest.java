package uiTest;

import driver.Driver;
import helper.BrowserManager;
import helper.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.AccountAndSettings.BasicSettingsPage;
import pages.AccountAndSettings.DomainPage;
import pages.AccountAndSettings.Gamification.*;
import pages.AccountAndSettings.SubscriptionPage;
import pages.AccountAndSettings.ThemesPage;
import pages.LoginPage;
import pages.Users.UsersPage;

public class BaseTest {

    protected WebDriver driver;
    protected WebElementHelper webElementHelper;
    protected BrowserManager browserManager;
    protected LoginPage loginPage;
    protected BasicSettingsPage basicSettingsPage;
    protected ThemesPage themesPage;
    protected DomainPage domainPage;
    protected SubscriptionPage subscriptionPage;
    protected GamificationPage gamificationPage;
    protected PointsBox pointsBox;
    protected BadgesBox badgesBox;
    protected LevelsBox levelsBox;
    protected RewardsBox rewardsBox;
    protected LeaderboardBox leaderboardBox;
    protected UsersPage usersPage;


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = Driver.getDriver();
        browserManager = new BrowserManager(driver);
        webElementHelper = new WebElementHelper();
        loginPage = new LoginPage();
        usersPage = new UsersPage();
        basicSettingsPage = new BasicSettingsPage();
        themesPage = new ThemesPage();
        domainPage = new DomainPage();
        subscriptionPage = new SubscriptionPage();
        gamificationPage = new GamificationPage();
        pointsBox =  new PointsBox();
        badgesBox = new BadgesBox();
        levelsBox = new LevelsBox();
        rewardsBox = new RewardsBox();
        leaderboardBox = new LeaderboardBox();
        browserManager.openByNavigate("https://app.talentlms.com/login");
        loginPage.enterDomain("fall2023")
                .enterUsername("nurik9816")
                .enterPassword("qwerty12345")
                .clickLoginButton();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Driver.closeDriver();

    }

}
