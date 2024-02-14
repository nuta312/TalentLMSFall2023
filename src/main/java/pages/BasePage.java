package pages;

import driver.Driver;
import helper.AlertHelper;
import helper.BrowserManager;
import helper.DropDownHelper;
import helper.FrameHelper;
import helper.WebElementHelper;
import helper.WindowHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BasePage {

    WebDriver webDriver;
    AlertHelper alertHelper = new AlertHelper();
    BrowserManager browserManager = new BrowserManager(webDriver);
    DropDownHelper dropDownHelper = new DropDownHelper();
    FrameHelper frameHelper = new FrameHelper(webDriver);
    WebElementHelper webElementHelper = new WebElementHelper();
    WindowHelper windowHelper = new WindowHelper();

    @BeforeClass
    public void seTup(){
        webDriver = Driver.getDriver();
        alertHelper = new AlertHelper();
        browserManager = new BrowserManager(webDriver);
        dropDownHelper = new DropDownHelper();
        frameHelper = new FrameHelper(webDriver);
        webElementHelper = new WebElementHelper();
        windowHelper = new WindowHelper();
    }

    @AfterClass
    public void closeRecourses(){
        webDriver.close();
        webDriver.quit();
    }

    public BasePage(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }
}
