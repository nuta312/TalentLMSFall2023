package uiTest.accountAndSettingsTests;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static ui.pages.TalentLMS_PAGES.TALENTLMS;
import static ui.pages.TalentLMS_PAGES.MY_DOMAIN;
import static ui.pages.TalentLMS_PAGES.DOMAIN;
import static ui.pages.TalentLMS_PAGES.DASHBOARD;
import static org.testng.Assert.assertEquals;

public class DomainTest extends BaseTest {

    @Test(description = "Rename domain name and click cancel button", groups = {"TLMS", "Regression", "UI", "103"})
    @Tag("Regression")
    public void renameDomainNameAndClickCancelTest() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + DOMAIN.getURL());
        talentLmsInitPages.domainPage.fillUpDomainNameInput("fall2023dg")
                .clickCancelButton();
        assertEquals(MY_DOMAIN.getURL() + TALENTLMS.getURL() + DASHBOARD.getURL(), "https://fall2023dg.talentlms.com/dashboard");
    }

    @Test(description = "Rename domain name positive test", groups = {"TLMS", "Regression", "UI", "104"})
    @Tag("Regression")
    public void renameDomainNameTest() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + DOMAIN.getURL());
        talentLmsInitPages.domainPage.fillUpDomainNameInput("")
                        .clickChangeDomainButton();
        assertEquals(talentLmsInitPages.domainPage.successRenameDomainMessage.getText(), "Domain name changed");
    }
}
