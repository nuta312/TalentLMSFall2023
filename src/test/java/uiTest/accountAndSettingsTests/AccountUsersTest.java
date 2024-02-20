package uiTest.accountAndSettingsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static pages.TalentLMS_PAGES.ACCOUNT_SETTINGS_USERS;
import static pages.TalentLMS_PAGES.DASHBOARD;

public class AccountUsersTest extends BaseTest {

    @Test(description = "Fill up users form and click 'Cancel' button amd move to Dashboard")
    public void usersIndexPageCancelTest(){
        browserManager.openByNavigate(ACCOUNT_SETTINGS_USERS.toString());
        accountUsersPage
                .fillSelectSignUp()
                .fillSelectDefaultUserType()
                .fillSelectDefaultGroup()
                .clickPasswordSetting()
                .fillCheckboxStrongPasswords()
                .fillCheckboxChangePassword()
                .fillCheckboxPasswordChange()
                .fillCheckboxLockAccount()
                .fillInputFailedAttempts()
                .fillInputFailedAttemptsPerMinutes()
                .clickTermOfService()
                .fillInputText()
                .fillVisibleUserFormat()
                .fillSelectUserName()
                .clickOnHidenSocialOptions()
                .fillCheckboxSocialMedia()
                .fillCheckboxCatalog()
                .fillCheckboxLknCertificate()
                .clickCancelButton();
        Assert.assertEquals(DASHBOARD.toString(), "https://fall2023.talentlms.com/dashboard");
    }
}
