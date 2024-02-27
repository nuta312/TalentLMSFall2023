package uiTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ExportTest extends BaseTest {
    @Test(description = "Verify export functionality for Csv  files")
    void clickExportButtons() {
        exportPage
                .clickBtnExport()
                .clickExport()
                .CsvClick()
                .ExportClick();

String actualExportClick=driver.findElement(By.xpath("//a[normalize-space()='Export']")).getText();
Assert.assertEquals(actualExportClick,"Export");

    }
    @Test(description = "Verify export functionality for excell  files")
    void clickExcell() {
        exportPage
                .clickBtnExport()
                .clickExport()
                .clickExcell()
                .ExportClick();

    }
    @Test(description = "Verify export functionality for cancel  button")
    void clickCancel() {
        exportPage
                .clickBtnExport()
                .ClickCancel1();


    }
}



