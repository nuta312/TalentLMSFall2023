package uiTest.accountAndSettingsTests;

import uiTest.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.TalentLMS_PAGES.THEMES;

public class ThemesTest extends BaseTest {

    @Test
    public void selectRandomThemeTest(){
        browserManager.openByNavigate(THEMES.toString());
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
