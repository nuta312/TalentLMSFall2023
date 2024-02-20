package uiTest;


import org.testng.annotations.Test;
import pages.ExportPage;



public class ExportTest extends BaseTest {

    private ExportPage exportPage;


    @Test
    void clickExportButtons() {
        browserManager.openByNavigate("https://app.talentlms.com/login");
        loginPage.enterDomain("nur123")
                .enterUsername("nuraiym123")
                .enterPassword("123Hamza");
        exportPage
                .clickBtnExport()
                .clickExport()
                .CsvClick()
                .ExportClick();
    }


    /**
     * проверка теста
     */


    @Test(description = "Verify export functionality for excell  files")
    void clickExcell() {


        exportPage
                .clickBtnExport()
                .clickExport()
                .clickExcell()
                .ExportClick();
    }

    @Test
    void clickCancel() {
        exportPage
                .clickBtnExport()
                .ClickCancel1();

    }

}



