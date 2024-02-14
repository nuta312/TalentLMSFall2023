package managers;

import managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class WebElementManager {

    // 1. by ID
    public static WebElement findElementById(String ID) {
        return WebDriverManager.driver.findElement(By.id(ID));
    }

    public static void findElementByIdAndSendKeys(String ID, String data) {
        WebDriverManager.driver.findElement(By.id(ID)).sendKeys(data);
    }

    // 2. by Name
    public static WebElement findElementByName(String name) {
        return WebDriverManager.driver.findElement(By.name(name));

    }

    public static void findElementByNameAndSendKeys(String name, String data) {
        WebDriverManager.driver.findElement(By.name(name)).sendKeys(data);
    }

    // 3. by Tag
    public static WebElement findElementByTag(String tag) {
        return WebDriverManager.driver.findElement(By.tagName(tag));
    }

    public static void findElementByTagAndClick(String tag) {
        WebDriverManager.driver.findElement(By.tagName(tag)).click();
    }

    // 4. by Class name
    public static WebElement findElementByClassName(String className) {
        return WebDriverManager.driver.findElement(By.className(className));
    }

    // 5. by Link Text
    public static WebElement findElementByLinkText(String linkName) {
        return WebDriverManager.driver.findElement(By.linkText(linkName));
    }

    public static void findElementByLinkTextAndClick(String linkName) {
        WebDriverManager.driver.findElement(By.linkText(linkName)).click();
    }

    // 6. by Partial Link Text
    public static WebElement findElementByPartialLinkText(String linkName) {
        return WebDriverManager.driver.findElement(By.partialLinkText(linkName));
    }

    public static void findElementByPartialLinkTextAndClick(String linkName) {
        WebDriverManager.driver.findElement(By.partialLinkText(linkName)).click();
    }

    // 7. by XPath
    public static WebElement findElementByXPath(String xpath) {
        return WebDriverManager.driver.findElement(By.xpath(xpath));
    }

    public static void findElementByXPathAndSendKeys(String xpath, String data) {
        WebDriverManager.driver.findElement(By.xpath(xpath)).sendKeys(data);
    }

    // 8. by CssSelector
    public static WebElement findElementByCssSelector(String selectorName) {
        return WebDriverManager.driver.findElement(By.cssSelector(selectorName));
    }

    // 9. scrolling
    public static void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.driver;
        js.executeScript("window.scrollBy(0, 600)");
    }

    public void scrollBy(int offsetX, int offsetY) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.driver;
        String script = String.format("window.scrollBy(%d, %d)", offsetX, offsetY);
        js.executeScript(script);
    }

}

