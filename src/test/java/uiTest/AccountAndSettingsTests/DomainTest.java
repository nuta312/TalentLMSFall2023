package uiTest.AccountAndSettingsTests;

import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;
import static pages.URL_TalentLMS.DOMAIN_PAGE;
import static pages.URL_TalentLMS.DASHBOARD_PAGE;

public class DomainTest extends BaseTest {

    @Test(description = "Rename domain name and click cancel button", priority = 0)
    public void renameDomainNameAndClickCancelTest() {
        browserManager.openByNavigate(DOMAIN_PAGE.toString());
        domainPage.fillUpDomainNameInput("fall2023")
                .clickCancelButton();
        assertEquals(DASHBOARD_PAGE.toString(), "https://fall2023.talentlms.com/dashboard");
    }

    @Test(description = "Rename domain name positive test", priority = 1)
    public void renameDomainNameTest() {
        browserManager.openByNavigate(DOMAIN_PAGE.toString());
        domainPage.fillUpDomainNameInput("")
                        .clickChangeDomainButton();
        assertEquals(domainPage.successRenameDomainMessage.getText(), "Domain name changed");
    }

}
