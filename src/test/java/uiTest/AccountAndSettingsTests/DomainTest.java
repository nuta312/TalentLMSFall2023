package uiTest.AccountAndSettingsTests;

import org.testng.annotations.Test;
import uiTest.BaseTest;
import static org.testng.Assert.assertEquals;
import static pages.TalentLMS_PAGES.DOMAIN;
import static pages.TalentLMS_PAGES.DASHBOARD;

public class DomainTest extends BaseTest {

    @Test(description = "Rename domain name and click cancel button", priority = 0)
    public void renameDomainNameAndClickCancelTest() {
        browserManager.openByNavigate(DOMAIN.toString());
        domainPage.fillUpDomainNameInput("fall2023")
                .clickCancelButton();
        assertEquals(DASHBOARD.toString(), "https://fall2023.talentlms.com/dashboard");
    }

    @Test(description = "Rename domain name positive test", priority = 1)
    public void renameDomainNameTest() {
        browserManager.openByNavigate(DOMAIN.toString());
        domainPage.fillUpDomainNameInput("")
                        .clickChangeDomainButton();
        assertEquals(domainPage.successRenameDomainMessage.getText(), "Domain name changed");
    }
}
