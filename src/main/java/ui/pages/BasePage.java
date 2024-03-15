package ui.pages;

import ui.driver.Driver;
import ui.helper.BrowserManager;
import ui.helper.DropdownHelper;
import ui.helper.WebElementHelper;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;

public class BasePage {

    public WebElementHelper webElementHelper = new WebElementHelper();
    public DropdownHelper dropdownHelper = new DropdownHelper(Driver.getDriver());
    public BrowserManager.WindowHelper windowHelper = new BrowserManager.WindowHelper(Driver.getDriver());
    public BrowserManager.FrameHelper frameHelper = new BrowserManager.FrameHelper(Driver.getDriver());
    public Random random = new Random();
    public Select select;
    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    public BrowserManager browserManager = new BrowserManager(Driver.getDriver());

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
