package ui.pages.reports;

import ui.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

import java.util.List;

public class ReportsPage extends BasePage {

    WebDriver driver= Driver.getDriver();
    @FindBy(xpath = "(//div[@class='tl-bold-link']/child::*)[9]")
    public WebElement reportsLink;
    @FindBy(xpath = "//a[@title='User reports']")
    public WebElement userReportsLink;
    @FindBy(xpath = "//a[text()='Course reports']")
    public WebElement courseReportsLink;
    @FindBy(linkText = "Branch reports")
    public WebElement branchReportsLink;
    @FindBy(xpath = "//div//div/*[@title='Group reports']")
    public WebElement groupReportsLink;
    @FindBy(xpath = "//*[text()='SCORM reports']")
    public WebElement scormReportsLink;
    @FindBy(xpath = "//div/child::*[contains(text(),'Test')]")
    public WebElement testReportsLink;
    @FindBy(xpath = "//*[@title='Survey reports']")
    public WebElement surveyReportsLink;
    @FindBy(xpath = "//*[@title='Assignment reports']")
    public WebElement assignmentReportsLink;
    @FindBy(xpath = "//*[text()='ILT reports']")
    public WebElement iltReportsLink;
    @FindBy(xpath = "//*[text()='Custom reports']")
    public WebElement customReportsLink;
    @FindBy(linkText = "Overview")
    public WebElement overviewLink;
    @FindBy(linkText = "Infographics")
    public WebElement infographics;
    @FindBy(linkText = "Training matrix")
    public WebElement trainingMatrix;
    @FindBy(linkText = "Timeline")
    public WebElement timeLine;
    @FindBy(xpath = "//*[@data-period='today']")
    public WebElement todayBtn;
    @FindBy(xpath = "//*[@data-period='yesterday']")
    public WebElement yesterdayBtn;
    @FindBy(xpath = "//*[@data-period='week']")
    public WebElement weekBtn;
    @FindBy(xpath = "//*[@data-period='month']")
    public WebElement monthBtn;
    @FindBy(xpath = "//*[@data-period='year']")
    public WebElement yearBtn;
    @FindBy(xpath = "//*[@data-period='period']")
    public WebElement periodBtn;
    @FindBy(xpath = "//div/child::*[@id='tl-export-system']")
    public WebElement trainingProgress;
    @FindBy(xpath = "//a[@title='Reports']")
    public WebElement reportsBtn;
    @FindBy (id = "tl-infographic-custom-headtitle-1")
    public WebElement your_training_infographicText;

    /**
     * elements today,yesterday,week,month,year,period
     * @throws InterruptedException
     */
    public ReportsPage periodElements () throws InterruptedException {
        List<WebElement> listsOfElements = driver.findElements(By.xpath("//div[@class='btn-group tl-reports-btn-group']/a"));
        for (int i = 0; i < listsOfElements.size(); i++) {
            WebElement elementLists = listsOfElements.get(i);
            webElementHelper.click(elementLists);
            Thread.sleep(2000);
        }
        return this;
    }

    /**
     * all elements from the right side of page
     * @throws InterruptedException
     */

    public ReportsPage reportsList() throws InterruptedException {
        List<WebElement> reportsListsOfElements = driver.findElements(By.xpath("//div[@class='tl-content-sidebar tl-reports-content-sidebar']/div"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < reportsListsOfElements.size(); i++) {
            WebElement reportList = reportsListsOfElements.get(i);
            try {
                js.executeScript("arguments[0].scrollIntoView(true);", reportList);
                webElementHelper.click(reportList);
                Thread.sleep(2000);
                webElementHelper.click(driver.findElement(By.xpath("//a[@title='Reports']")));
                Thread.sleep(3000);
            } catch (StaleElementReferenceException e) {
                reportsListsOfElements =driver.findElements(By.xpath("//div[@class='tl-content-sidebar tl-reports-content-sidebar']/div"));
                System.out.println("Элемент устарел. Повторно получен список.");
                i--;
            }
        }
        return this;
    }
}