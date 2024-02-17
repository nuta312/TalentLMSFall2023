package uiTest;

import driver.Driver;
import helper.BrowserManager;
import helper.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import pages.AccountAndSettings.BasicSettingsPage;
import pages.AccountAndSettings.ThemesPage;
import pages.AccountAndSettings.CertificatesPage;
import pages.AccountAndSettings.DomainPage;
import pages.AccountAndSettings.SubscriptionPage;
import pages.AccountAndSettings.Gamification.GamificationPage;
import pages.AccountAndSettings.Gamification.PointsBox;
import pages.AccountAndSettings.Gamification.BadgesBox;
import pages.AccountAndSettings.Gamification.LevelsBox;
import pages.AccountAndSettings.Gamification.RewardsBox;
import pages.AccountAndSettings.Gamification.LeaderboardBox;
import pages.Users.UsersPage;
import static pages.TalentLMS_PAGES.LOGIN;
import static config.ConfigReader.getValue;

public class BaseTest {

    protected WebDriver driver;
    protected WebElementHelper webElementHelper;
    protected BrowserManager browserManager;
    protected LoginPage loginPage;
    protected BasicSettingsPage basicSettingsPage;
    protected ThemesPage themesPage;
    protected CertificatesPage certificatesPage;
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
    public void setUp(){
        driver = Driver.getDriver();
        browserManager = new BrowserManager(driver);
        webElementHelper = new WebElementHelper();
        loginPage = new LoginPage();
        usersPage = new UsersPage();
        basicSettingsPage = new BasicSettingsPage();
        themesPage = new ThemesPage();
        certificatesPage = new CertificatesPage();
        domainPage = new DomainPage();
        subscriptionPage = new SubscriptionPage();
        gamificationPage = new GamificationPage();
        pointsBox =  new PointsBox();
        badgesBox = new BadgesBox();
        levelsBox = new LevelsBox();
        rewardsBox = new RewardsBox();
        leaderboardBox = new LeaderboardBox();
        browserManager.openByNavigate(LOGIN.toString());
        loginPage.enterDomain(getValue("domain"))
                .enterUsername(getValue("username"))
                .enterPassword(getValue("password"))
                .clickLoginButton();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        Driver.closeDriver();
    }
}
