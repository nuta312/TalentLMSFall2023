package uiTest;

import ui.driver.Driver;
import ui.helper.BrowserManager;
import ui.helper.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static ui.pages.TalentLMS_PAGES.LOGIN_PAGE;

public class BaseTest {

    protected WebDriver driver;
    protected WebElementHelper webElementHelper;
    protected BrowserManager browserManager;
    protected BrowserManager.WindowHelper windowHelper;
    protected BrowserManager.FrameHelper frameHelper;
    public TalentLmsInitPages talentLmsInitPages;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = Driver.getDriver();
        webElementHelper = new WebElementHelper();
        browserManager = new BrowserManager(driver);
        windowHelper = new BrowserManager.WindowHelper(driver);
        frameHelper = new BrowserManager.FrameHelper(driver);
        talentLmsInitPages = new TalentLmsInitPages();
        talentLmsInitPages.initPages();
        driver.get(LOGIN_PAGE.getURL());
        talentLmsInitPages.loginPage.doLogin();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
       Driver.closeDriver();
    }
}