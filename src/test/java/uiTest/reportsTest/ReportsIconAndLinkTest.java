package uiTest.reportsTest;

import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;

public class ReportsIconAndLinkTest extends BaseTest {

    @Test(description = "method clicks on the Reports icon, then clicks on Home\n" +
            "and then clicks on the Reports link")
    void openReportsIconAndLink(){
        reportsIconAndLinkPage.clickReportsIcon()
                .clickHomeLink()
                .clickReportsLink();
        assertEquals(reportsIconAndLinkPage.homeClick.getText(), "Home");
    }
}