package ui.pages.importExport;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class ExportPage extends BasePage {

    @FindBy(xpath = "//a[normalize-space()='Export']")
    public WebElement exportBtnClick;
    @FindBy(xpath = "//span[text()='EXCEL']")
    public WebElement exportTypeFind;
    @FindBy (xpath = "(//div[@class='select2-result-label'])[2]")
    public WebElement clickCSV;
    @FindBy(xpath = "(//div[@class='select2-result-label'])[1]")
    public WebElement clickExcell;
    @FindBy(xpath = "//a[contains(text(),'cancel')]")
    public WebElement clickCancel;
    @FindBy(xpath = "(//input[@class='btn btn-primary'])[1]")
    public WebElement clickExportButton;

    public ExportPage clickBtnExport(){
        webElementHelper.click(exportBtnClick);
        return this;
    }

    public ExportPage clickExport() {
        webElementHelper.click(exportTypeFind);
        return this;
    }

    public ExportPage csvClick() {
        webElementHelper.click(clickCSV);
        return this;
    }

    public ExportPage clickExcell() {
        webElementHelper.click(clickExcell);
        return this;
    }

    public ExportPage clickCancel1(){
         webElementHelper.click(clickCancel);
         return this;
    }

    public ExportPage exportClick(){
        webElementHelper.click(clickExportButton);
        return this;
    }
}