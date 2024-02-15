package uiTest.AccountAndSettingsTests;

import org.testng.annotations.Test;
import uiTest.BaseTest;
import static org.testng.Assert.assertEquals;
import static pages.URL_TalentLMS.BASIC_SETTINGS_PAGE;

public class BasicSettingsTest extends BaseTest {

    @Test(description = "Changing basic settings")
    public void fillUpBasicSettingsTest() throws InterruptedException {
        browserManager.openByNavigate(BASIC_SETTINGS_PAGE.toString());
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
