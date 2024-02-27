package uiTest.usersTest;

import org.testng.annotations.Test;
import pages.users.UsersPage;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;

public class UsersTest extends BaseTest {


    @Test(description = "Sign in to browser and choose the Add User field", priority = 0)
    public void addUserTest() {
        browserManager.openByNavigate("https://guli86.talentlms.com/user/create");
        webElementHelper.click(usersPage.homeAddUserBtn);
        usersPage
                .fillUpUserWithFakerData()
                .selectUserType()
                .selectTimeZone()
                .selectLanguage()
                .clickOnExcludeFromEmailsCheckbox()
                .clickOnAddUserSubmitBtn();
        assertEquals(usersPage.addUserSuccessMessage.getText(), "Success! Do you want to add another user?");
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

    @Test(description = "Sign in to browser and choose the Add User field", priority = 0)

    public void addUserTest2() throws InterruptedException {

        browserManager.openByNavigate("https://guli86.talentlms.com/user/create");
        usersPage
                .fillUpUserWithFakerData()
                .selectUserType()
                .clickOnAddUserSubmitBtn();

        browserManager.openByNavigate("https://guli86.talentlms.com/user/index");
        UsersPage.getUsersFromTable(driver);
        Thread.sleep(5000);
// WebElement deleteBtn = driver.findElement(By.xpath("//a[@data-mode='delete']"));
//            deleteBtn.click();
        usersPage
                .deleteLastAddedUser();
    }


    //assertEquals(usersPage.addUserSuccessMessage.getText(), "Success! Do you want to add another user?");


    @Test(description = "Click on empty fields", priority = 1)
    public void requiredFieldsMessagesTest2(){
        browserManager.openByNavigate("https://guli86.talentlms.com/user/index");
        webElementHelper.click(usersPage.homeAddUserBtn);
        usersPage.clickOnAddUserSubmitBtn();
        assertEquals(usersPage.nameIsRequiredMessage.getText(), "'First name' is required");
        assertEquals(usersPage.lastNameIsRequiredMessage.getText(), "'Last name' is required");
        assertEquals(usersPage.userNameMessage.getText(), "'Username' is required");
        assertEquals(usersPage.emailMessage.getText(), "'Email address' is required");
    }



}