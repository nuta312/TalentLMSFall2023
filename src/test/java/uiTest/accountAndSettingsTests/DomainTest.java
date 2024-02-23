package uiTest.accountAndSettingsTests;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static pages.TalentLMS_PAGES.TALENTLMS;
import static pages.TalentLMS_PAGES.MY_DOMAIN;
import static pages.TalentLMS_PAGES.DOMAIN;
import static pages.TalentLMS_PAGES.DASHBOARD;
import static org.testng.Assert.assertEquals;

public class DomainTest extends BaseTest {

    @Tag("Regress")
    @Test(description = "Rename domain name and click cancel button")
    public void renameDomainNameAndClickCancelTest() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + DOMAIN);
        domainPage.fillUpDomainNameInput("fall2023dg")
                .clickCancelButton();
        assertEquals(MY_DOMAIN.toString() + TALENTLMS + DASHBOARD, "https://fall2023dg.talentlms.com/dashboard");
    }

    @Tag("Regress")
    @Test(description = "Rename domain name positive test")
    public void renameDomainNameTest() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + DOMAIN);
        domainPage.fillUpDomainNameInput("")
                        .clickChangeDomainButton();
        assertEquals(domainPage.successRenameDomainMessage.getText(), "Domain name changed");
    }
}
