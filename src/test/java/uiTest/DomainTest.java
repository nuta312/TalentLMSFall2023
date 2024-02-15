package uiTest;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.DomainPage;

public class DomainTest {
    WebDriver driver;

    public DomainTest() {
        this.driver = Driver.getDriver();
    }

    @Test
    void Domain() throws InterruptedException {
        driver.get("https://fall2023.talentlms.com/index");
        DomainPage domainPage = new DomainPage();
        BaseTest baseTest = new BaseTest();
        baseTest.setUp();
        domainPage
                .PathDomain()
                .DomainName()
                .MapACustomDomain()
                .PopupWindow()
                .UpgradeClick()
                .Rename()
                .CancelClick()
                .ClickHome()
                .ChangeName();
        baseTest.setUp();
        domainPage.ReturnToDomain();
        driver.quit();
    }
}

