package uiTest.reportsTest;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import uiTest.BaseTest;
import java.util.List;

import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertEquals;
import static ui.pages.reports.UserReportsPage.getColumnNameData;
import static ui.pages.reports.UserReportsPage.getColumnNameTypeData;
import static ui.pages.reports.UserReportsPage.sortUserTypeData;
import static ui.pages.reports.UserReportsPage.selectTextFromTableForSearch;
import static ui.pages.reports.UserReportsPage.isTextFoundInSearchResults;
import static ui.pages.reports.UserReportsPage.sortData;

public class UserReportsPageTest extends BaseTest {

    @Test(groups = {"TLMS", "Smoke", "UI", "142"})
    @Feature("Sorting")
    @Description("Verify user tables sorting after clicking user column sort button")
    @Epic("SCRUM-12")
    @Owner("Urmat")
    @Severity(SeverityLevel.CRITICAL)
    @Story("TL-037")
    @Tag("Smoke")
    @Flaky
    public void verify_user_table_sorting_after_clicking_user_column_sort_button() {
        talentLmsInitPages.userReportsPage
                .goToTheCustomReportsPage()
                .clickSortButtonForColumnName()
                .clickButtonToDisplayTheWholeTable();
        List<String> tableDataBeforeClickingTheSortButton = getColumnNameData();
        talentLmsInitPages.userReportsPage.clickSortButtonForColumnName();
        List<String> tableDataAfterClickingTheSortButton = getColumnNameData();
        List<String> tableDataBeforeClickingTheSortButtonAfterSorting = sortData(tableDataBeforeClickingTheSortButton);
        assertEquals(tableDataBeforeClickingTheSortButtonAfterSorting, tableDataAfterClickingTheSortButton);
    }

    @Test(groups = {"TLMS", "Smoke", "UI", "143"})
    @Feature("Sorting")
    @Description("Verify user type tables sorting after clicking user column sort button")
    @Epic("SCRUM -12")
    @Owner("Urmat")
    @Severity(SeverityLevel.CRITICAL)
    @Story("TL-037")
    @Tag("Smoke")
    @Flaky
    public void verify_user_type_table_sorting_after_clicking_user_column_sort_button() {
        talentLmsInitPages.userReportsPage
                .goToTheCustomReportsPage()
                .clickButtonToDisplayTheWholeTable();
        List<String> tableDataBeforeClickingTheSortButton = getColumnNameTypeData();
        talentLmsInitPages.userReportsPage.clickSortButtonForColumnUserType();
        List<String> tableDataAfterClickingTheSortButton = getColumnNameTypeData();
        List<String> tableDataBeforeClickingTheSortButtonAfterSorting = sortUserTypeData(tableDataBeforeClickingTheSortButton);
        assertEquals(tableDataBeforeClickingTheSortButtonAfterSorting, tableDataAfterClickingTheSortButton);
    }

    @Test(groups = {"TLMS", "Smoke", "UI", "144"})
    @Feature("Search")
    @Description("Testing of table search functionality")
    @Epic("SCRUM-12")
    @Owner("Urmat")
    @Severity(SeverityLevel.CRITICAL)
    @Story("TL-037")
    @Tag("Smoke")
    @Flaky
    public void Testing_of_table_search_functionality() {
        talentLmsInitPages.userReportsPage.goToTheCustomReportsPage();
        List<String> tableData = getColumnNameData();
        String searchText = selectTextFromTableForSearch(tableData);
        boolean result = isTextFoundInSearchResults(searchText);
        System.out.println(result);
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

