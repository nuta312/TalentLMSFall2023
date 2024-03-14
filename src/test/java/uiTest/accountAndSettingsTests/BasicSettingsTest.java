package uiTest.accountAndSettingsTests;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static ui.pages.TalentLMS_PAGES.MY_DOMAIN;
import static ui.pages.TalentLMS_PAGES.TALENTLMS;
import static ui.pages.TalentLMS_PAGES.BASIC_SETTINGS;
import static org.testng.Assert.assertEquals;

public class BasicSettingsTest extends BaseTest {

    @Test(description = "Changing basic settings", groups = {"TLMS", "Regression", "UI", "101"})
    @Tag("Regression")
    public void fillUpBasicSettingsTest() throws InterruptedException {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + BASIC_SETTINGS.getURL());
        talentLmsInitPages.basicSettingsPage.fillUpDescription("123")
                .selectRandomLogo()
                .selectRandomFavicon()
                .selectLanguage()
                .selectTimeZone()
                .selectDateFormat()
                .selectTimeFormat()
                .selectCurrency()
                .selectConferenceMode()
                .inputCapacity()
                .clickSaveChanges();
        assertEquals(talentLmsInitPages.basicSettingsPage.successSavingMessage.getText(), "Basic settings updated successfully");
    }
}
