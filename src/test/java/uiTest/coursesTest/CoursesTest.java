package uiTest.coursesTest;

import org.testng.annotations.Test;
import uiTest.BaseTest;

public class CoursesTest extends BaseTest {

    @Test
    void add() {

        coursesPage.addCourse();
    }
}