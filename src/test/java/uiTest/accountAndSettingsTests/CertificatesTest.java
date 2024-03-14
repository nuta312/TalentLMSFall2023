package uiTest.accountAndSettingsTests;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static ui.pages.TalentLMS_PAGES.MY_DOMAIN;
import static ui.pages.TalentLMS_PAGES.TALENTLMS;
import static ui.pages.TalentLMS_PAGES.CERTIFICATES;
import static org.testng.Assert.assertEquals;

public class CertificatesTest extends BaseTest {

    @Test(description = "Upload your own certificate and save it as new", groups = {"TLMS", "Regression", "UI", "102"})
    @Tag("Regression")
    public void saveNewCertificateTest() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + CERTIFICATES.getURL());
        talentLmsInitPages.certificatesPage.uploadOwnCertificate()
                .clickSaveAsNewButton()
                .fillUpCertificateName()
                .clickSaveCertificateButton();
        assertEquals(talentLmsInitPages.certificatesPage.successSaveAsNewMessage.getText(), "Operation completed successfully");
    }
}
