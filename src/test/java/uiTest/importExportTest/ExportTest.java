package uiTest.importExportTest;

import io.qameta.allure.testng.Tag;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import uiTest.BaseTest;

public class ExportTest extends BaseTest {

    @Test(description = "Verify export functionality for Csv files", groups = {"TLMS", "Regression", "UI", "129"})
    @Tag("Regression")
    public void clickExportButtonsTest() {
        talentLmsInitPages.exportPage
                .clickBtnExport()
                .clickExport()
                .csvClick()
                .exportClick();
        String actualExportClick=driver.findElement(By.xpath("//a[normalize-space()='Export']")).getText();
        Assert.assertEquals(actualExportClick,"Export");
    }

    @Test(description = "Verify export functionality for excell files", groups = {"TLMS", "Regression", "UI", "130"})
    @Tag("Regression")
    public void clickExcellTest() {
        talentLmsInitPages.exportPage
                .clickBtnExport()
                .clickExport()
                .clickExcell()
                .exportClick();
    }

    @Test(description = "Verify export functionality for cancel  button", groups = {"TLMS", "Regression", "UI", "131"})
    @Tag("Regression")
    public void clickCancelTest() {
        talentLmsInitPages.exportPage
                .clickBtnExport()
                .clickCancel1();
    }
}