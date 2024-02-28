package pages.importExport;

import helper.WebElementHelper;
import org.apache.commons.compress.utils.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.io.IOException;
import java.io.InputStream;

public class ImportPage extends BasePage {


   @FindBy(xpath = "//a[normalize-space()='Import']")
    public WebElement importLink;
     @FindBy(xpath = "//div[@id='files_namespace']//input[@type='file']")
    public WebElement dropCSVExcelIcon;
     @FindBy(xpath = "//pre[@id='tl-import-results']")
     public WebElement importResults;
     @FindBy(xpath =" //div[@class='CodeMirror-lines']")//used in CheatListTest
    public WebElement importDescriptionInput;
    @FindBy(xpath = "//input[@value='Import']")
    public WebElement importButton;
    @FindBy(xpath = "//i[@class='icon-download tl-icon-stack-content']")
    public WebElement sampleExcelFileIcon;
    @FindBy(xpath = "//div[@id='tl-toggle-sample-data']")
    public WebElement viewCheatsheetLink;
    @FindBy(xpath = "//a[@class='btn tl-example-paste-code']")
    public WebElement useThisExample;


    public WebDriver driver;

    public ImportPage enterImportPageByRef(){
        importLink.click();
        return this;
    }
    public void clickImportButton() {
        importButton.click();
    }

//    public void uploadFile(WebDriver driver, String filePath) {
//        WebElement fileInput = driver.findElement(By.xpath("//div[@id='files_namespace']//input[@type='file']"));
//        fileInput.sendKeys(filePath);
//      // dropCSVExcelIcon.sendKeys(filePath);
//    }


    public void uploadFile(WebDriver driver, String filepath) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(filepath);
            if (inputStream != null) {
                WebElement fileInput = driver.findElement(By.xpath("//div[@id='files_namespace']//input[@type='file']"));
                fileInput.sendKeys(filepath);
            } else {
                throw new IOException("File not found: " + filepath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addDescription(String txt){
        importDescriptionInput.sendKeys(txt);
    }

    public void clickSampleExcelFile(WebDriver driver) {
        WebElementHelper webElementHelper = new WebElementHelper();
        //webElementHelper.clickWithScrollToElement(sampleExcelFileIcon);
        sampleExcelFileIcon.click();
    }

    public void clickViewCheatsheetButton() {
        viewCheatsheetLink.click();
        webElementHelper.jsClick(useThisExample).click(useThisExample);
    }








}
