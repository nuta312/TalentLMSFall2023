package uiTest.usersTest;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;

public class UsersTest extends BaseTest {

    @Test(description = "Sign in to browser and choose the Add User field", groups = {"TLMS", "Smoke", "UI", "147"}, priority = 0)
    @Tag("Smoke")
    public void addUserTest() {
        webElementHelper.click(talentLmsInitPages.usersPage.homeAddUserBtn);
        talentLmsInitPages.usersPage
                .fillUpUserWithFakerData()
                .selectUserType()
                .selectTimeZone()
                .selectLanguage()
                .clickOnExcludeFromEmailsCheckbox()
                .clickOnAddUserSubmitBtn();
        assertEquals(talentLmsInitPages.usersPage.addUserSuccessMessage.getText(), "Success! Do you want to add another user?");
    }

    @Test(description = "Click on empty fields", groups = {"TLMS", "Smoke", "UI", "148"}, priority = 1)
    @Tag("Smoke")
    public void requiredFieldsMessagesTest() {
        webElementHelper.click(talentLmsInitPages.usersPage.homeBtn);
        webElementHelper.click(talentLmsInitPages.usersPage.homeAddUserBtn);
        talentLmsInitPages.usersPage.clickOnAddUserSubmitBtn();
        assertEquals(talentLmsInitPages.usersPage.nameIsRequiredMessage.getText(), "'First name' is required");
        assertEquals(talentLmsInitPages.usersPage.lastNameIsRequiredMessage.getText(), "'Last name' is required");
        assertEquals(talentLmsInitPages.usersPage.userNameMessage.getText(), "'Username' is required");
        assertEquals(talentLmsInitPages.usersPage.emailMessage.getText(), "'Email address' is required");
    }
}
