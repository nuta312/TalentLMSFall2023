package uiTest;

import driver.Driver;
import helper.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected WebElementHelper webElementHelper;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = Driver.getDriver();
        webElementHelper = new WebElementHelper();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        Driver.closeDriver();

    }

}
