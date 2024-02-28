package uiTest.userTypeTest;

import io.qameta.allure.Feature;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.Test;
import uiTest.BaseTest;
import java.util.List;

import static pages.TalentLMS_PAGES.MY_DOMAIN;
import static pages.TalentLMS_PAGES.TALENTLMS;
import static pages.TalentLMS_PAGES.USER_TYPES;

public class UserTypesTest extends BaseTest {

    private String nameUserType;
    private int indexUserType;

    @Test
    @Feature("talentLMS User Types")
    @Description("Checking when adding user type it must be unique")
    @Owner("Timur")
    @Severity(SeverityLevel.CRITICAL)
    @Story("TL-014")
    @Tag("Negative")
    public void addDuplicateUserTypeInTableTest() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + USER_TYPES);
        nameUserType = "duplicate";
        indexUserType = 1;
        userTypesPage.addNotUniqueUserType(nameUserType, indexUserType);
        String actualResult = userTypesPage.warningTextTypeNameRepeated.getText().trim();
        String expectedResult = "A user type with this name already exists";
        Assert.assertEquals(actualResult, expectedResult);
        browserManager.goBack();
        userTypesPage.removeTestsUsersTypes(driver);
    }

    @Test
    @Feature("talentLMS User Types")
    @Description("Adding a new role to a table")
    @Owner("Timur")
    @Severity(SeverityLevel.CRITICAL)
    @Story("TL-014")
    @Tag("Smoke")
    public void addUserTypeInTableTest(){
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + USER_TYPES);
        nameUserType = "testUserTypeName";
        indexUserType = 2;
        userTypesPage.addUserType(nameUserType, indexUserType);
        userTypesPage.addUserType("Men", indexUserType);
        Assert.assertTrue(userTypesPage.checkUserInTable(nameUserType));
        userTypesPage.removeTestsUsersTypes(driver);
    }

    @Test
    @Feature("talentLMS User Types")
    @Description("Checking the table information search string")
    @Owner("Timur")
    @Severity(SeverityLevel.NORMAL)
    @Story("TL-014")
    @Tag("Smoke")
    public void searchFieldTest(){
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + USER_TYPES);
        int attempts = 0;
        String searchWord = "admin";
        webElementHelper.sendKeys(userTypesPage.searchField, searchWord);
        while(attempts < 10){
            listUserTypes = userTypesPage.getRolesFromTable();
            if(userTypesPage.countingRowsInTable(listUserTypes, searchWord) == listUserTypes.size()){
                break;
            }
            attempts++;
        }
        userTypesPage.searchFieldClear();
        Assert.assertTrue(userTypesPage.countingRowsInTable(listUserTypes, searchWord) == listUserTypes.size());
        userTypesPage.removeTestsUsersTypes(driver);
    }

    @Test
    @Feature("talentLMS User Types")
    @Description("Filter check user type name table user type")
    @Owner("Timur")
    @Severity(SeverityLevel.MINOR)
    @Story("TL-014")
    @Tag("Smoke")
    public void filterUserTypeNameInTableUserTypeTest() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + USER_TYPES);
        List<String> beforeSortUserTypesName;
        List<String> afterSortUserTypesName;
        beforeSortUserTypesName = userTypesPage.getRolesFromTable();
        webElementHelper.click(userTypesPage.filterUserTypeNameInTableUserType);
        afterSortUserTypesName = userTypesPage.getRolesFromTable();
        Assert.assertTrue(userTypesPage.checkFilterUserTypeNameInTableUserType(beforeSortUserTypesName, afterSortUserTypesName));
    }
}