package uiTest.reportsTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import uiTest.BaseTest;

public class CoursesUnderReportsTest extends BaseTest {

    @Test(description = "method clicks on the Courses link, then clicks on all the course tabs in turn")
    void clickCoursesUnderReports(){
        reportsIconAndLinkPage.clickLinkUnderReports(coursesUnderReportsPage.coursesLink);
        coursesUnderReportsPage.clickAdvancedFeatures();
        browserManager.goBack();
        coursesUnderReportsPage.clickContentAndTLMS();
        browserManager.goBack();
        coursesUnderReportsPage.clickEmployeeTraining();
        browserManager.goBack();
        coursesUnderReportsPage.clickGettingWithStarting();
        browserManager.goBack();
        coursesUnderReportsPage.clickGiveYourCourseAName();
        browserManager.goBack();
        coursesUnderReportsPage.clickIntroductionToTLMS();
        browserManager.goBack();
        coursesUnderReportsPage.clickWhatIsTLMSLibrary()
                .clickScormTab()
                .clickNestedWhatIsTLMSLibrary();
        Assert.assertEquals(coursesUnderReportsPage.assertText.getText(),
                "There's no info to report, at the moment");
    }
}