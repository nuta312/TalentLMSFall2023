package uiTest;

import org.testng.annotations.Test;
import pages.Users.UsersPage;


import static org.testng.Assert.assertEquals;

public class UsersTest extends BaseTest {

    @Test(description = "Sign in to browser and choose the Add User field", priority = 0)
    public void addUserTest() throws InterruptedException {
        webElementHelper.click(usersPage.homeAddUserBtn);
        usersPage
                .fillUpUserWithFakerData()
                .selectUserType()
                .selectTimeZone()
                .selectLanguage()
                .clickOnExcludeFromEmailsCheckbox()
                .clickOnAddUserSubmitBtn();
//            for getting from table and delete it
        browserManager.openByNavigate("https://nur123.talentlms.com/user/index");
        usersPage.getUsersFromTable(driver);
        Thread.sleep(5000);

        usersPage
                .deleteLastAddedUser();
    }
    @Test(description = "Click on empty fields", priority = 1)
    public void requiredFieldsMessagesTest() {
        webElementHelper.click(usersPage.homeBtn);
        webElementHelper.click(usersPage.homeAddUserBtn);
        usersPage.clickOnAddUserSubmitBtn();
        assertEquals(usersPage.nameIsRequiredMessage.getText(), "'First name' is required");
        assertEquals(usersPage.lastNameIsRequiredMessage.getText(), "'Last name' is required");
        assertEquals(usersPage.userNameMessage.getText(), "'Username' is required");
        assertEquals(usersPage.emailMessage.getText(), "'Email address' is required");
    }
}
