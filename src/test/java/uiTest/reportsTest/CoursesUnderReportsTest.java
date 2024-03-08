package uiTest.reportsTest;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;

public class CoursesUnderReportsTest extends BaseTest {

    @Test(description = "method clicks on the Courses link, then clicks on all the course tabs in turn", groups = {"TLMS", "Regression", "UI", "132"})
    @Tag("Regression")
    public void clickCoursesUnderReportsTest() {
        talentLmsInitPages.reportsIconAndLinkPage.clickLinkUnderReports(talentLmsInitPages.coursesUnderReportsPage.coursesLink);
        talentLmsInitPages.coursesUnderReportsPage.clickAdvancedFeatures();
        browserManager.goBack();
        talentLmsInitPages.coursesUnderReportsPage.clickContentAndTLMS();
        browserManager.goBack();
        talentLmsInitPages.coursesUnderReportsPage.clickEmployeeTraining();
        browserManager.goBack();
        talentLmsInitPages.coursesUnderReportsPage.clickGettingWithStarting();
        browserManager.goBack();
        talentLmsInitPages.coursesUnderReportsPage.clickGiveYourCourseAName();
        browserManager.goBack();
        talentLmsInitPages.coursesUnderReportsPage.clickIntroductionToTLMS();
        browserManager.goBack();
        talentLmsInitPages.coursesUnderReportsPage.clickWhatIsTLMSLibrary()
                .clickScormTab()
                .clickNestedWhatIsTLMSLibrary();
        assertEquals(talentLmsInitPages.coursesUnderReportsPage.assertText.getText(),
                "There's no info to report, at the moment");
    }
}