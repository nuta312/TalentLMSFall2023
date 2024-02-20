package uiTest.accountAndSettingsTests;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;
import static pages.TalentLMS_PAGES.DOMAIN;
import static pages.TalentLMS_PAGES.DASHBOARD;

public class DomainTest extends BaseTest {

    @Tag("Regress")
    @Test(description = "Rename domain name and click cancel button")
    public void renameDomainNameAndClickCancelTest(){
        browserManager.openByNavigate(DOMAIN.toString());
        domainPage.fillUpDomainNameInput("fall2023")
                .clickCancelButton();
        assertEquals(DASHBOARD.toString(), "https://fall2023.talentlms.com/dashboard");
    }

    @Tag("Regress")
    @Test(description = "Rename domain name positive test")
    public void renameDomainNameTest(){
        browserManager.openByNavigate(DOMAIN.toString());
        domainPage.fillUpDomainNameInput("")
                        .clickChangeDomainButton();
        assertEquals(domainPage.successRenameDomainMessage.getText(), "Domain name changed");
    }
}
