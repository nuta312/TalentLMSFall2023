package uiTest.accountAndSettingsTests;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;
import static ui.pages.TalentLMS_PAGES.MY_DOMAIN;
import static ui.pages.TalentLMS_PAGES.TALENTLMS;
import static ui.pages.TalentLMS_PAGES.ACCOUNT_SETTINGS_USERS;
import static ui.pages.TalentLMS_PAGES.DASHBOARD;

public class AccountUsersTest extends BaseTest {

    @Test(description = "Fill up users form and click 'Cancel' button amd move to Dashboard", groups = {"TLMS", "Regression", "UI", "100"})
    @Tag("Regression")
    public void usersIndexPageCancelTest() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + ACCOUNT_SETTINGS_USERS.getURL());
        talentLmsInitPages.accountUsersPage
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
        assertEquals(MY_DOMAIN.getURL() + TALENTLMS.getURL() + DASHBOARD.getURL(), "https://fall2023dg.talentlms.com/dashboard");
    }
}
