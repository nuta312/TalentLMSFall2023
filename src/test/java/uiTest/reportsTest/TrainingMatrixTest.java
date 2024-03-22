package uiTest.reportsTest;

import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static ui.pages.TalentLMS_PAGES.MY_DOMAIN;
import static ui.pages.TalentLMS_PAGES.TALENTLMS;
import static ui.pages.TalentLMS_PAGES.DASHBOARD;

public class TrainingMatrixTest extends BaseTest {

    @Test(description = "Click all elements of courses ", groups = {"TLMS", "Regression", "UI", "139"})
    @Tag("Regression")
    public void courseElementsClick() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + DASHBOARD.getURL());
        talentLmsInitPages.trainingMatrixPage.clickAllElements();
    }

    @Test (description = "Dropdown checkbox check", groups = {"TLMS", "Regression", "UI", "140"})
    @Tag("Regression")
    public void checkBoxsTest() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + DASHBOARD.getURL());
        talentLmsInitPages.trainingMatrixPage.dropDownClick();
    }

    @Test (description = "Assert the text", groups = {"TLMS", "Regression", "UI", "141"})
    @Tag("Regression")
    public void checkTheText() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + DASHBOARD.getURL());
        webElementHelper.click(talentLmsInitPages.reportsPage.trainingMatrix);
        Assert.assertEquals(talentLmsInitPages.trainingMatrixPage.trainingMatrixText.getText(),"Training matrix");
    }
}