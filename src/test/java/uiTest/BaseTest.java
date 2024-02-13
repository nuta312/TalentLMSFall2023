package uiTest;

import drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    protected WebDriver driver;
    protected Actions actions;


    @BeforeClass
    public void setUp(){
        driver = Driver.getDriver();
        actions = new Actions(driver);
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}

