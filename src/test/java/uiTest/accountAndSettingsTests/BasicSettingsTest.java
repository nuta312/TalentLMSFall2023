package uiTest.accountAndSettingsTests;

import org.testng.annotations.Test;
import uiTest.BaseTest;

import static ui.pages.TalentLMS_PAGES.MY_DOMAIN;
import static ui.pages.TalentLMS_PAGES.TALENTLMS;
import static ui.pages.TalentLMS_PAGES.BASIC_SETTINGS;
import static org.testng.Assert.assertEquals;

public class BasicSettingsTest extends BaseTest {

    @Test(description = "Changing basic settings")
    public void fillUpBasicSettingsTest() throws InterruptedException {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + BASIC_SETTINGS);
        basicSettingsPage.fillUpDescription("123")
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
        assertEquals(basicSettingsPage.successSavingMessage.getText(), "Basic settings updated successfully");
    }
}
