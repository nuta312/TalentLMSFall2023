package ui.pages.reports;

import ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

import java.util.List;

public class TrainingMatrixPage extends BasePage {

    ReportsPage reportsPage =new ReportsPage();
    WebDriver driver= Driver.getDriver();
    @FindBy (css = ".tl-matrix-settings-btn")
    public WebElement dropDownBtn;
    @FindBy (xpath = "//a[text()='Training matrix']")
    public WebElement trainingMatrixText;

    public TrainingMatrixPage clickAllElements() {
        webElementHelper.click(reportsPage.trainingMatrix);
        List<WebElement> elements = driver.findElements(By.xpath("//tr[@role='row']//child::th/div/span/span"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            webElementHelper.click(element);
        }
        windowHelper.switchToParentWithChildClose();
        return this;
    }

    public TrainingMatrixPage dropDownClick() {
        webElementHelper.click(reportsPage.reportsLink)
                .click(reportsPage.trainingMatrix)
                .click(dropDownBtn);
        List<WebElement> dropDownLists = driver.findElements(By.xpath("//ul[@class='dropdown-menu pull-right']/child::li/label"));
        for (int i = 0; i < dropDownLists.size(); i++){
            WebElement dropDownList = dropDownLists.get(i);
            webElementHelper.click(dropDownList);
        }
        webElementHelper.click(dropDownBtn);
        return this;
    }
}