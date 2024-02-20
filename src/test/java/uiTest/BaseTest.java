package uiTest;

import driver.Driver;
import helper.BrowserManager;
import helper.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

public class BaseTest {

    protected WebDriver driver;
    protected WebElementHelper webElementHelper;
    protected LoginPage loginPage;
    protected BrowserManager browserManager;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = Driver.getDriver();
        browserManager = new BrowserManager(driver);
        webElementHelper = new WebElementHelper();
        loginPage = new LoginPage();
        browserManager.openByNavigate("https://app.talentlms.com/login");
        loginPage.enterDomain("asyl2024")
                .enterUsername("asikosan2014@gmail.com")
                .enterPassword("asyl2024")
                .clickLoginButton();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Driver.closeDriver();

    }

}
