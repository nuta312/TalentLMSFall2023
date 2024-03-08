package uiTest.reportsTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.SeverityLevel;
import listener.ScreenshotListener;
import org.openqa.selenium.By;
import uiTest.BaseTest;
import java.util.List;

import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertEquals;
import static pages.reports.UserReportsPage.columnNameFromTheTable;
import static pages.reports.UserReportsPage.columnUserTypeFromTheTable;
import static pages.reports.UserReportsPage.getColumnNameData;
import static pages.reports.UserReportsPage.getColumnNameTypeData;
import static pages.reports.UserReportsPage.sortUserTypeData;
import static pages.reports.UserReportsPage.sortData;
import static pages.reports.UserReportsPage.selectTextFromTableForSearch;
import static pages.reports.UserReportsPage.isTextFoundInSearchResults;

@Listeners(ScreenshotListener.class)
public class UserReportsPageTest extends BaseTest {

    @Test(groups = {"TLMS", "Smoke", "UI", "142"})
    @Feature("Sorting.")
    @Description("Verify user tables sorting after clicking user column sort button")
    @Epic("SCRUM-12")
    @Owner("Urmat")
    @Severity(SeverityLevel.CRITICAL)
    @Story("TL-037")
    @Tag("Smoke")
    public void verify_user_table_sorting_after_clicking_user_column_sort_button() {
        talentLmsInitPages.userReportsPage
                .goToTheCustomReportsPage()
                .clickSortButtonForColumnName()
                .clickButtonToDisplayTheWholeTable()
                .pause(1000);
        List<String> tableDataBeforeClickingTheSortButton
                = getColumnNameData(talentLmsInitPages.userReportsPage.tableRows, columnNameFromTheTable);
        talentLmsInitPages.userReportsPage
                .clickSortButtonForColumnName()
                .pause(1000);
        List<String> tableDataAfterClickingTheSortButton
                = getColumnNameData(talentLmsInitPages.userReportsPage.tableRows, columnNameFromTheTable);
        List<String> tableDataBeforeClickingTheSortButtonAfterSorting
                = sortData(tableDataBeforeClickingTheSortButton);
        assertEquals(
                "Table not sorted correctly"
                , tableDataBeforeClickingTheSortButtonAfterSorting
                , tableDataAfterClickingTheSortButton);
    }

    @Test(groups = {"TLMS", "Smoke", "UI", "143"})
    @Feature("Sorting")
    @Description("Verify user type tables sorting after clicking user column sort button")
    @Epic("SCRUM -12")
    @Owner("Urmat")
    @Severity(SeverityLevel.CRITICAL)
    @Story("TL-037")
    @Tag("Smoke")
    public void verify_user_type_table_sorting_after_clicking_user_column_sort_button() {
        talentLmsInitPages.userReportsPage
                .goToTheCustomReportsPage()
                .clickButtonToDisplayTheWholeTable()
                .pause(1000);
        List<String> tableDataBeforeClickingTheSortButton
                = getColumnNameTypeData(talentLmsInitPages.userReportsPage.tableRows, columnUserTypeFromTheTable);
        talentLmsInitPages.userReportsPage
                .clickSortButtonForColumnUserType()
                .pause(1000);
        List<String> tableDataAfterClickingTheSortButton
                = getColumnNameTypeData(talentLmsInitPages.userReportsPage.tableRows, columnUserTypeFromTheTable);
        List<String> tableDataBeforeClickingTheSortButtonAfterSorting
                = sortUserTypeData(tableDataBeforeClickingTheSortButton);
        assertEquals(
                "Table not sorted correctly"
                , tableDataBeforeClickingTheSortButtonAfterSorting
                , tableDataAfterClickingTheSortButton);
    }

    @Test(groups = {"TLMS", "Smoke", "UI", "144"})
    @Feature("Search")
    @Description("Testing of table search functionality")
    @Epic("SCRUM-12")
    @Owner("Urmat")
    @Severity(SeverityLevel.CRITICAL)
    @Story("TL-037")
    @Tag("Smoke")
    public void Testing_of_table_search_functionality() {
        talentLmsInitPages.userReportsPage
                .goToTheCustomReportsPage();
        List<String> tableDataBeforeClickingTheSortButton
                = getColumnNameData(talentLmsInitPages.userReportsPage.tableRows, columnNameFromTheTable);
        String searchText
                = selectTextFromTableForSearch(tableDataBeforeClickingTheSortButton);
        boolean result
                = isTextFoundInSearchResults(searchText);
        if (!result) {
            fail("user search on the page does not work correctly");
        }
    }

    @Test(groups = {"TLMS", "Smoke", "UI", "145"})
    @Feature("User profile navigation and progress display feature")
    @Description("Automated test to verify the proper navigation to the user profile, " +
            "showcasing progress data, triggered by clicking on the user name in the user table")
    @Epic("SCRUM-12")
    @Owner("Urmat")
    @Severity(SeverityLevel.MINOR)
    @Story("TL-037")
    @Tag("Smoke")
    public void user_profile_and_progress_on_click() {
        talentLmsInitPages.userReportsPage
                .goToTheCustomReportsPage()
                .clickTextNameFromTable();
        String expected = "Activity";
        String actual = driver.findElement(By.xpath("//div[text()='Activity']")).getText();
        assertEquals(expected, actual);
    }
}

