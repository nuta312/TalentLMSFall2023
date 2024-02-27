package uiTest.importExportTest;

import config.ConfigReader;
import helper.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.importExport.ImportPage;
import uiTest.BaseTest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImportTest extends BaseTest {
    ImportPage importPage = new ImportPage();
    @Test(description = "enter the page by import refference Click")
    void enterImportByImportReff()  {
        importPage.enterImportPageByRef();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("talentlms.com/import"), "URL не содержит talentlms.com/import");
    }
    @Test(description = "download Sample file")
    void SampleFileDownload() {
        importPage.importLink.click();
        importPage.clickSampleExcelFile(driver);
        String downloadsPath = System.getProperty("user.home") + "/Downloads";
        String filePath = ConfigReader.getValue("filepath") + "/Import-Samples.xls";
        Path path = Paths.get(filePath);
        boolean fileExists = Files.exists(path);
       Assert.assertTrue(fileExists, "Файл не был скачан успешно");
    }
    @Test(description = "Upload valid file in 'Drop a csv or excel file here or browse' field")
    void testFileUploadPositive() throws InterruptedException {
        importPage.importLink.click();
        String filePath = ConfigReader.getValue("filepath") + "/Import-Samples.xls";
        importPage.downloadFile(driver, filePath);
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='note success text-success' and contains(text(), 'Upload complete. Click the import button to proceed.')]"));
        Assert.assertNotNull(successMessage);
    }

    @Test(description = "upload valid file,check 'description' field, check 'Import' btn")
    void testFileUploadAndSubmitPositive() {
        importPage.importLink.click();
        String filePath = ConfigReader.getValue("filepath") + "/Import-Samples.xls";
        importPage.downloadFile(driver, filePath);
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='note success text-success' and contains(text(), 'Upload complete. Click the import button to proceed.')]"));
        Assert.assertNotNull(successMessage);
        System.out.println(importPage.importDescriptionInput.getText());
        WebElement modifyData = importPage.importDescriptionInput;
        Assert.assertFalse(modifyData.getText().isEmpty());
        importPage.clickImportButton();
        WebElementHelper importResults = new WebElementHelper().waitForElementToBeDisplayed(importPage.importResults);
        Assert.assertNotNull(importResults);
    }



    @Test(description = "cheat list btn, view cheatlist, cheat List Excample use")
    void testViewCheatsheet() {
        importPage.importLink.click();
        importPage.clickViewCheatsheetButton();
        webElementHelper.waitForElementToBeDisplayed(importPage.useThisExample);
        Assert.assertTrue(importPage.useThisExample.isDisplayed());
        System.out.println(importPage.importDescriptionInput.getText());
        WebElement modifyData = importPage.importDescriptionInput;
        Assert.assertTrue(modifyData.getText().contains("Login; Firstname; Lastname; Email"));
    }
}







