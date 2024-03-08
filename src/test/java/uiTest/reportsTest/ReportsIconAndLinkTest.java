package uiTest.reportsTest;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;

public class ReportsIconAndLinkTest extends BaseTest {

    @Test(description = "method clicks on the Reports icon, then clicks on Home\n" +
            "and then clicks on the Reports link", groups = {"TLMS", "Regression", "UI", "133"})
    @Tag("Regression")
    public void openReportsIconAndLinkTest() {
        talentLmsInitPages.reportsIconAndLinkPage.clickReportsIcon()
                .clickHomeLink()
                .clickReportsLink();
        assertEquals(talentLmsInitPages.reportsIconAndLinkPage.homeClick.getText(), "Home");
    }
}