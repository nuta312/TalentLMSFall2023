package uiTest.reportsTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;
import static ui.pages.TalentLMS_PAGES.MY_DOMAIN;
import static ui.pages.TalentLMS_PAGES.TALENTLMS;
import static ui.pages.TalentLMS_PAGES.DASHBOARD;

public class ReportsTest extends BaseTest {

    @Test(description = "Assert in reports page")
    public void checkTheText() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + DASHBOARD);
        webElementHelper.click(reportsPage.reportsLink);
        Assert.assertEquals(reportsPage.overviewLink.getText(), "Overview");
    }

    @Test(description = "Click to infographics tab and assert text")
    public void infographicsClick() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + DASHBOARD);
        reportsPage.infographics.click();
        assertEquals(reportsPage.your_training_infographicText.getText(), "Your training infographic".toUpperCase());
    }

    @Test(description = "Click to training matrix tab")
    public void trainingMatrixTest() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + DASHBOARD);
        webElementHelper.click(reportsPage.trainingMatrix);
    }

    @Test(description = "Click to all elements of period time")
    public void test78() throws InterruptedException {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + DASHBOARD);
        webElementHelper.click(reportsPage.reportsLink);
        reportsPage.periodElements();
    }

    @Test(description = "All right side 10 elements,click")
    public void test() throws InterruptedException {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + DASHBOARD);
        webElementHelper.click(reportsPage.reportsLink);
        reportsPage.reportsList();
    }
}