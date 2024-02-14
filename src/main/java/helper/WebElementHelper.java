package helper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebElementHelper {
    private Select select;
    public WebElementHelper waitForButtonToBeClickAble(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7)).until(ExpectedConditions.elementToBeClickable(element));
        return this;

    }
    public WebElementHelper waitForElementToBeDisplayed(WebElement element){
        new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
        return this;
    }
    public WebElementHelper click(WebElement element){
        waitForButtonToBeClickAble(element);
        element.click();
        return this;
    }
    public WebElementHelper sendKeys(WebElement element,String txt){
        waitForElementToBeDisplayed(element);
        element.sendKeys(txt);
        return this;
    }
    public WebElementHelper scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;

    }
    public WebElementHelper sendKeysWithEnter(WebElement element, String txt){
        waitForElementToBeDisplayed(element);
        element.sendKeys(txt);
        element.sendKeys(Keys.ENTER);
        return this;
    }
}
