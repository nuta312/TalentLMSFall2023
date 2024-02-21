package uiTest.reportsTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static pages.TalentLMS_PAGES.DASHBOARD;

public class TrainingMatrixTest extends BaseTest {
    @Test(description = "Click all elements of courses ")
    public void courseElementsClick() throws InterruptedException {
        browserManager.openByNavigate(DASHBOARD.toString());
        trainingMatrixPage.clickAllElements();
    }

    @Test (description = "Dropdown checkbox check")
    public void checkBoxsTest (){
        browserManager.openByNavigate(DASHBOARD.toString());
        trainingMatrixPage.dropDownClick();
    }

    @Test (description = "Assert the text")
    public void checkTheText(){
        browserManager.openByNavigate(DASHBOARD.toString());
        webElementHelper.click(reportsPage.trainingMatrix);
        Assert.assertEquals(trainingMatrixPage.trainingMatrixText.getText(),"Training matrix");
    }
}