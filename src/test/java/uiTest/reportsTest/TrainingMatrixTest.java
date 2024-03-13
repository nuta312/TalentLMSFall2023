package uiTest.reportsTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static ui.pages.TalentLMS_PAGES.MY_DOMAIN;
import static ui.pages.TalentLMS_PAGES.TALENTLMS;
import static ui.pages.TalentLMS_PAGES.DASHBOARD;

public class TrainingMatrixTest extends BaseTest {

    @Test(description = "Click all elements of courses ")
    public void courseElementsClick() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + DASHBOARD);
        trainingMatrixPage.clickAllElements();
    }

    @Test (description = "Dropdown checkbox check")
    public void checkBoxsTest () {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + DASHBOARD);
        trainingMatrixPage.dropDownClick();
    }

    @Test (description = "Assert the text")
    public void checkTheText() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + DASHBOARD);
        webElementHelper.click(reportsPage.trainingMatrix);
        Assert.assertEquals(trainingMatrixPage.trainingMatrixText.getText(),"Training matrix");
    }
}