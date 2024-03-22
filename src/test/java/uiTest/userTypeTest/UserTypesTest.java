package uiTest.userTypeTest;

import io.qameta.allure.Feature;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ui.pages.TalentLMS_PAGES.MY_DOMAIN;
import static ui.pages.TalentLMS_PAGES.TALENTLMS;
import static ui.pages.TalentLMS_PAGES.USER_TYPES;

public class UserTypesTest extends BaseTest {

    private String nameUserType;
    private int indexUserType;

    @Test(groups = {"TLMS", "Regression", "UI", "155"})
    @Feature("talentLMS User Types")
    @Description("Checking when adding user type it must be unique")
    @Owner("Timur")
    @Severity(SeverityLevel.CRITICAL)
    @Story("TL-014")
    @Tag("Regression")
    public void addDuplicateUserTypeInTableTest() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + USER_TYPES.getURL());
        nameUserType = "duplicate";
        indexUserType = 1;
        talentLmsInitPages.userTypesPage.addNotUniqueUserType(nameUserType, indexUserType);
        String actualResult = talentLmsInitPages.userTypesPage.warningTextTypeNameRepeated.getText().trim();
        String expectedResult = "A user type with this name already exists";
        assertEquals(actualResult, expectedResult);
        browserManager.goBack();
        talentLmsInitPages.userTypesPage.removeTestsUsersTypes(driver);
    }

    @Test(groups = {"TLMS", "Regression", "UI", "156"})
    @Feature("talentLMS User Types")
    @Description("Adding a new role to a table")
    @Owner("Timur")
    @Severity(SeverityLevel.CRITICAL)
    @Story("TL-014")
    @Tag("Regression")
    public void addUserTypeInTableTest(){
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + USER_TYPES.getURL());
        nameUserType = "testUserTypeName";
        indexUserType = 2;
        talentLmsInitPages.userTypesPage.addUserType(nameUserType, indexUserType);
        talentLmsInitPages.userTypesPage.addUserType("Men", indexUserType);
        assertTrue(talentLmsInitPages.userTypesPage.checkUserInTable(nameUserType));
        talentLmsInitPages.userTypesPage.removeTestsUsersTypes(driver);
    }

    @Test(groups = {"TLMS", "Regression", "UI", "157"})
    @Feature("talentLMS User Types")
    @Description("Checking the table information search string")
    @Owner("Timur")
    @Severity(SeverityLevel.NORMAL)
    @Story("TL-014")
    @Tag("Regression")
    public void searchFieldTest(){
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + USER_TYPES.getURL());
        int attempts = 0;
        String searchWord = "admin";
        webElementHelper.sendKeys(talentLmsInitPages.userTypesPage.searchField, searchWord);
        while(attempts < 10){
            talentLmsInitPages.listUserTypes = talentLmsInitPages.userTypesPage.getRolesFromTable();
            if(talentLmsInitPages.userTypesPage.countingRowsInTable(talentLmsInitPages.listUserTypes, searchWord) == talentLmsInitPages.listUserTypes.size()){
                break;
            }
            attempts++;
        }
        talentLmsInitPages.userTypesPage.searchFieldClear();
        assertTrue(talentLmsInitPages.userTypesPage.countingRowsInTable(talentLmsInitPages.listUserTypes, searchWord) == talentLmsInitPages.listUserTypes.size());
        talentLmsInitPages.userTypesPage.removeTestsUsersTypes(driver);
    }

    @Test(groups = {"TLMS", "Regression", "UI", "158"})
    @Feature("talentLMS User Types")
    @Description("Filter check user type name table user type")
    @Owner("Timur")
    @Severity(SeverityLevel.MINOR)
    @Story("TL-014")
    @Tag("Regression")
    public void filterUserTypeNameInTableUserTypeTest() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + USER_TYPES.getURL());
        List<String> beforeSortUserTypesName;
        List<String> afterSortUserTypesName;
        beforeSortUserTypesName = talentLmsInitPages.userTypesPage.getRolesFromTable();
        webElementHelper.click(talentLmsInitPages.userTypesPage.filterUserTypeNameInTableUserType);
        afterSortUserTypesName = talentLmsInitPages.userTypesPage.getRolesFromTable();
        assertTrue(talentLmsInitPages.userTypesPage.checkFilterUserTypeNameInTableUserType(beforeSortUserTypesName, afterSortUserTypesName));
    }
}