package uiTest.accountAndSettingsTests;

import uiTest.BaseTest;
import org.testng.annotations.Test;

import static pages.TalentLMS_PAGES.MY_DOMAIN;
import static pages.TalentLMS_PAGES.TALENTLMS;
import static pages.TalentLMS_PAGES.THEMES;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ThemesTest extends BaseTest {

    @Test
    public void selectRandomThemeTest() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + THEMES);
        themesPage.selectRandomTheme()
                .activeThemeButtonClick();
        webElementHelper.click(themesPage.updateThemeButton)
                .waitForElementToBeDisplayed(themesPage.successMessage);
        assertEquals(themesPage.successMessage.getText(), "Operation completed successfully");
        assertTrue(themesPage.updateThemeButton.isDisplayed());
        assertTrue(themesPage.saveAsNewButton.isDisplayed());
        assertTrue(themesPage.deleteButton.isDisplayed());
    }
}
