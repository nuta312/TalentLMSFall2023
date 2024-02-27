package pages;

import com.github.javafaker.Faker;
import driver.Driver;
import helper.DropdownHelper;
import helper.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;

public class BasePage {
    public WebDriver driver = Driver.getDriver();

    public WebElementHelper webElementHelper = new WebElementHelper();
    public DropdownHelper dropdownHelper = new DropdownHelper(Driver.getDriver());
    public Random random = new Random();
    Faker faker = new Faker();
    public Select select;
    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
