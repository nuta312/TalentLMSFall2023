package uiTest.AccountAndSettingsTests;

import uiTest.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.URL_TalentLMS.THEMES_PAGE;

public class ThemesTest extends BaseTest {

    @Test
    void selectRandomThemeTest()  {
        browserManager.openByNavigate(THEMES_PAGE.toString());
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
