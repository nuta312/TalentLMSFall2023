package uiTest.accountAndSettingsTests;

import io.qameta.allure.testng.Tag;
import uiTest.BaseTest;
import org.testng.annotations.Test;

import static pages.TalentLMS_PAGES.MY_DOMAIN;
import static pages.TalentLMS_PAGES.TALENTLMS;
import static pages.TalentLMS_PAGES.THEMES;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ThemesTest extends BaseTest {

    @Test(description = "Select random theme", groups = {"TLMS", "Regression", "UI"})
    @Tag("Regression")
    public void selectRandomThemeTest() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + THEMES.getURL());
        talentLmsInitPages.themesPage.selectRandomTheme()
                .activeThemeButtonClick();
        webElementHelper.click(talentLmsInitPages.themesPage.updateThemeButton)
                .waitForElementToBeDisplayed(talentLmsInitPages.themesPage.successMessage);
        assertEquals(talentLmsInitPages.themesPage.successMessage.getText(), "Operation completed successfully");
        assertTrue(talentLmsInitPages.themesPage.updateThemeButton.isDisplayed());
        assertTrue(talentLmsInitPages.themesPage.saveAsNewButton.isDisplayed());
        assertTrue(talentLmsInitPages.themesPage.deleteButton.isDisplayed());
    }
}
