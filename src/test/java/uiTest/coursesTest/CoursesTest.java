package uiTest.coursesTest;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.AssertJUnit.assertEquals;

public class CoursesTest extends BaseTest {

    @Test(groups = {"TLMS", "Smoke", "UI", "122"}, priority = 1)
    @Tag("Smoke")
    public void addTest() {
        talentLmsInitPages.coursesPage.addCourse();
        assertEquals("Success! New course created. Now, add users or add content to it.", talentLmsInitPages.coursesPage.messageAfterCreateCourse.getText());
        talentLmsInitPages.coursesPage.clickToCoursePart();
    }

    @Test(groups = {"TLMS", "Smoke", "UI", "123"}, priority = 3)
    @Tag("Smoke")
    public void cloneTest() {
        talentLmsInitPages.coursesPage.cloneTheCourse();
        removeTest();
    }

    @Test(groups = {"TLMS", "Smoke", "UI", "124"}, priority = 2)
    @Tag("Smoke")
    public void editTest() {
        talentLmsInitPages.coursesPage.editCourse();
        assertEquals("Success! Course updated.", talentLmsInitPages.coursesPage.messageAfterEditCourse.getText());
    }

    @Test(groups = {"TLMS", "Smoke", "UI", "125"}, priority = 4)
    @Tag("Smoke")
    public void removeTest() {
        talentLmsInitPages.coursesPage.removeCourse();
    }
}