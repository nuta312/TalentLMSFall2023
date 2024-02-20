package uiTest.accountAndSettingsTests;

import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;
import static pages.TalentLMS_PAGES.CERTIFICATES;

public class CertificatesTest extends BaseTest {

    @Test(description = "Upload your own certificate and save it as new")
    public void saveNewCertificateTest(){
        browserManager.openByNavigate(CERTIFICATES.toString());
        certificatesPage.uploadOwnCertificate()
                .clickSaveAsNewButton()
                .fillUpCertificateName()
                .clickSaveCertificateButton();
        assertEquals(certificatesPage.successSaveAsNewMessage.getText(), "Operation completed successfully");
    }
}
