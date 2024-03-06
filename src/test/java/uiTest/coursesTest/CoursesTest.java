package uiTest.coursesTest;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.AssertJUnit.assertEquals;

public class CoursesTest extends BaseTest {

    @Test(priority = 1)
    @Tag("Smoke")
    public void addTest() {
        talentLmsInitPages.coursesPage.addCourse();
        assertEquals("Success! New course created. Now, add users or add content to it.", talentLmsInitPages.coursesPage.messageAfterCreateCourse.getText());
        talentLmsInitPages.coursesPage.clickToCoursePart();
    }

    @Test(priority = 3)
    @Tag("Smoke")
    public void cloneTest() {
        talentLmsInitPages.coursesPage.cloneTheCourse();
        removeTest();
    }

    @Test(priority = 2)
    @Tag("Smoke")
    public void editTest() {
        talentLmsInitPages.coursesPage.editCourse();
        assertEquals("Success! Course updated.", talentLmsInitPages.coursesPage.messageAfterEditCourse.getText());
    }

    @Test(priority = 4)
    @Tag("Smoke")
    public void removeTest() {
        talentLmsInitPages.coursesPage.removeCourse();
    }
}