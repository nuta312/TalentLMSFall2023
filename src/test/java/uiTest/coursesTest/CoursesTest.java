package uiTest.coursesTest;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.AssertJUnit.assertEquals;

@Tag("Smoke")
public class CoursesTest extends BaseTest {

    @Test(priority = 1)
    void addTest() {
        coursesPage.addCourse();
        assertEquals("Success! New course created. Now, add users or add content to it.", coursesPage.messageAfterCreateCourse.getText());
        coursesPage.clickToCoursePart();
    }

    @Test(priority = 3)
    void cloneTest() {
        coursesPage.cloneTheCourse();
        removeTest();
    }

    @Test(priority = 2)
    void editTest() {
        coursesPage.editCourse();
        assertEquals("Success! Course updated.", coursesPage.messageAfterEditCourse.getText());
    }

    @Test(priority = 4)
    void removeTest() {
        coursesPage.removeCourse();
    }
}