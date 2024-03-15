package uiTest.accountAndSettingsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static ui.pages.TalentLMS_PAGES.MY_DOMAIN;
import static ui.pages.TalentLMS_PAGES.TALENTLMS;
import static ui.pages.TalentLMS_PAGES.ACCOUNT_SETTINGS_USERS;
import static ui.pages.TalentLMS_PAGES.DASHBOARD;

public class AccountUsersTest extends BaseTest {

    @Test(description = "Fill up users form and click 'Cancel' button amd move to Dashboard")
    public void usersIndexPageCancelTest() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + ACCOUNT_SETTINGS_USERS);
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
        Assert.assertEquals(MY_DOMAIN.toString() + TALENTLMS + DASHBOARD, "https://fall2023.talentlms.com/dashboard");
    }
}
