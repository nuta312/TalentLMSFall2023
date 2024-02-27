package uiTest.accountAndSettingsTests;
import org.testng.annotations.Test;
import uiTest.BaseTest;
import static pages.TalentLMS_PAGES.MY_DOMAIN;
import static pages.TalentLMS_PAGES.TALENTLMS;
import static pages.TalentLMS_PAGES.CERTIFICATES;
import static org.testng.Assert.assertEquals;

public class CertificatesTest extends BaseTest {

    @Test(description = "Upload your own certificate and save it as new")
    public void saveNewCertificateTest() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + CERTIFICATES);
        certificatesPage.uploadOwnCertificate()
                .clickSaveAsNewButton()
                .fillUpCertificateName()
                .clickSaveCertificateButton();
        assertEquals(certificatesPage.successSaveAsNewMessage.getText(), "Operation completed successfully");
    }
}
