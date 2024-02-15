package helper;

import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementHelper {

    Actions actions;

    public WebElementHelper waitForButtonToBeClickAble(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public WebElementHelper waitForElementToBeDisplayed(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementHelper click(WebElement element){
        waitForButtonToBeClickAble(element);
        element.click();
        return this;
    }

    public WebElementHelper clickWithScrollToElement(WebElement element){
        waitForButtonToBeClickAble(element);
        scrollToElement(element);
        element.click();
        return this;
    }

    public WebElementHelper jsClick(WebElement element){
        waitForButtonToBeClickAble(element);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", element);
        return this;
    }

    public WebElementHelper doubleClick(WebElement element){
        waitForButtonToBeClickAble(element);
        actions.doubleClick(element);
        return this;
    }

    public WebElementHelper sendKeys(WebElement element, String input){
        waitForButtonToBeClickAble(element);
        element.sendKeys(input);
        return this;
    }

    public WebElementHelper scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

}
