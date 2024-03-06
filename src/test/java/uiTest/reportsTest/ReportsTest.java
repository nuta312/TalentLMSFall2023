package uiTest.reportsTest;

import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;
import static pages.TalentLMS_PAGES.MY_DOMAIN;
import static pages.TalentLMS_PAGES.TALENTLMS;
import static pages.TalentLMS_PAGES.DASHBOARD;

public class ReportsTest extends BaseTest {

    @Test(description = "Assert in reports page")
    @Tag("Regression")
    public void checkTheText() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + DASHBOARD.getURL());
        webElementHelper.click(talentLmsInitPages.reportsPage.reportsLink);
        Assert.assertEquals(talentLmsInitPages.reportsPage.overviewLink.getText(), "Overview");
    }

    @Test(description = "Click to infographics tab and assert text")
    @Tag("Regression")
    public void infographicsClick() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + DASHBOARD.getURL());
        talentLmsInitPages.reportsPage.infographics.click();
        assertEquals(talentLmsInitPages.reportsPage.your_training_infographicText.getText(), "Your training infographic".toUpperCase());
    }

    @Test(description = "Click to training matrix tab")
    @Tag("Regression")
    public void trainingMatrixTest() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + DASHBOARD.getURL());
        webElementHelper.click(talentLmsInitPages.reportsPage.trainingMatrix);
    }

    @Test(description = "Click to all elements of period time")
    @Tag("Regression")
    public void test78() throws InterruptedException {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + DASHBOARD.getURL());
        webElementHelper.click(talentLmsInitPages.reportsPage.reportsLink);
        talentLmsInitPages.reportsPage.periodElements();
    }

    @Test(description = "All right side 10 elements,click")
    @Tag("Regression")
    public void test() throws InterruptedException {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + DASHBOARD.getURL());
        webElementHelper.click(talentLmsInitPages.reportsPage.reportsLink);
        talentLmsInitPages.reportsPage.reportsList();
    }
}