package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExportPage extends BasePage {

    @FindBy(xpath = "//a[normalize-space()='Export']")
    public WebElement ExportBtnClick;
    @FindBy(xpath = "//span[text()='EXCEL']")
    public WebElement ExportTypeFind;
    @FindBy (xpath = "(//div[@class='select2-result-label'])[2]")
    public WebElement clickCSV;
    @FindBy(xpath = "(//div[@class='select2-result-label'])[1]")
    public WebElement clickExcell;
    @FindBy(xpath = "//a[contains(text(),'cancel')]")
    public WebElement clickCancel;
    @FindBy(xpath = "(//input[@class='btn btn-primary'])[1]")
    public WebElement clickExportButton;

    public ExportPage clickBtnExport(){
        webElementHelper.click(ExportBtnClick);
        return this;
    }

    public ExportPage clickExport() {
        webElementHelper.click(ExportTypeFind);
        return this;
    }

    public ExportPage CsvClick() {
        webElementHelper.click(clickCSV);
        return this;
    }

    public ExportPage clickExcell() {
        webElementHelper.click(clickExcell);
        return this;
    }

    public ExportPage ClickCancel1(){
         webElementHelper.click(clickCancel);
         return this;
    }

    public ExportPage ExportClick(){
        webElementHelper.click(clickExportButton);
        return this;
    }
}