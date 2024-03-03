package uiTest.reportsTest;import io.qameta.allure.*;import io.qameta.allure.testng.Tag;import listener.ScreenshotListener;import org.openqa.selenium.By;import org.testng.Assert;import org.testng.annotations.Listeners;import org.testng.annotations.Test;import uiTest.BaseTest;import java.util.List;import static org.testng.AssertJUnit.assertEquals;import static pages.reports.UserReportsPage.*;@Listeners(ScreenshotListener.class)public class UserReportsPageTest extends BaseTest {    @Test()    @Feature("Sorting")    @Description("Verify user tables sorting after clicking user column sort button")    @Epic("SCRUM-12")    @Owner("Urmat")    @Severity(SeverityLevel.CRITICAL)    @Story("TL-037")    @Tag("Smoke")    void verify_user_table_sorting_after_clicking_user_column_sort_button() {        userReportsPage                .goToTheCustomReportsPage()                .clickSortButtonForColumnName()                .clickButtonToDisplayTheWholeTable()                .pause(1000);        List<String> tableDataBeforeClickingTheSortButton                = getColumnNameData(userReportsPage.tableRows, columnNameFromTheTable);        userReportsPage                .clickSortButtonForColumnName()                .pause(1000);        List<String> tableDataAfterClickingTheSortButton                = getColumnNameData(userReportsPage.tableRows, columnNameFromTheTable);        List<String> tableDataBeforeClickingTheSortButtonAfterSorting                = sortData(tableDataBeforeClickingTheSortButton);        assertEquals(                "Table not sorted correctly"                , tableDataBeforeClickingTheSortButtonAfterSorting                , tableDataAfterClickingTheSortButton);    }    @Test()    @Feature("Sorting")    @Description("Verify user type tables sorting after clicking user column sort button")    @Epic("SCRUM-12")    @Owner("Urmat")    @Severity(SeverityLevel.CRITICAL)    @Story("TL-037")    @Tag("Smoke")    void verify_user_type_table_sorting_after_clicking_user_column_sort_button() {        userReportsPage                .goToTheCustomReportsPage()                .clickButtonToDisplayTheWholeTable()                .pause(1000);        List<String> tableDataBeforeClickingTheSortButton                = getColumnNameTypeData(userReportsPage.tableRows, columnUserTypeFromTheTable);        userReportsPage                .clickSortButtonForColumnUserType()                .pause(1000);        List<String> tableDataAfterClickingTheSortButton                = getColumnNameTypeData(userReportsPage.tableRows, columnUserTypeFromTheTable);        List<String> tableDataBeforeClickingTheSortButtonAfterSorting                = sortUserTypeData(tableDataBeforeClickingTheSortButton);        assertEquals(                "Table not sorted correctly"                , tableDataBeforeClickingTheSortButtonAfterSorting                , tableDataAfterClickingTheSortButton);    }    @Test()    @Feature("Search")    @Description("Testing of table search functionality")    @Epic("SCRUM-12")    @Owner("Urmat")    @Severity(SeverityLevel.CRITICAL)    @Story("TL-037")    @Tag("Smoke")    void Testing_of_table_search_functionality() {        userReportsPage                .goToTheCustomReportsPage();        List<String> tableDataBeforeClickingTheSortButton                = getColumnNameData(userReportsPage.tableRows, columnNameFromTheTable);        String searchText                = selectTextFromTableForSearch(tableDataBeforeClickingTheSortButton);        boolean result                = isTextFoundInSearchResults(searchText);        if (!result) {            Assert.fail("user search on the page does not work correctly");        }    }    @Test    @Feature("User profile navigation and progress display feature")    @Description("Automated test to verify the proper navigation to the user profile, " +            "showcasing progress data, triggered by clicking on the user name in the user table")    @Epic("SCRUM-12")    @Owner("Urmat")    @Severity(SeverityLevel.MINOR)    @Story("TL-037")    @Tag("Regression")    void user_profile_and_progress_on_click() {        userReportsPage                .goToTheCustomReportsPage()                .clickTextNameFromTable();        String expected = "Activity";        String actual = driver.findElement(By.xpath("//div[text()='Activity']")).getText();        Assert.assertEquals(expected, actual);    }}