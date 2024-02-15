package pages;

import driver.Driver;
import helper.DropdownHelper;
import helper.WebElementHelper;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class BasePage {

    WebElementHelper webElementHelper = new WebElementHelper();
    DropdownHelper driver = new DropdownHelper(Driver.getDriver());
    Random random = new Random();

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
