package ui.pages.accountAndSettings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ui.pages.BasePage;
import java.io.File;
import java.util.List;

import static config.ConfigReader.getValue;

public class CertificatesPage extends BasePage {

    @FindBy(css = "select[id='select-certificate']")
    public WebElement certificateDropdown;
    @FindBy(css = "input[name='custom_background']")
    public WebElement uploadCertificateButton;
    @FindBy(css = "input[id='preview-button']")
    public WebElement previewButton;
    @FindBy(xpath = "//a[@class='close']")
    public WebElement closePreviewButton;
    @FindBy(xpath = "//a[text()='Background']")
    public WebElement backgroundButton;
    @FindBy(xpath = "///a[text()='Template']")
    public WebElement templateButton;
    @FindBy(css = "input[id='update-certificate']")
    public WebElement updateButton;
    @FindBy(css = "input[id='save-as-new-button']")
    public WebElement saveAsNewButton;
    @FindBy(xpath = "//input[@id='certificate_name']")
    public WebElement inputCertificateName;
    @FindBy(xpath = "//a[text()='Save']")
    public WebElement saveCertificateButton;
    @FindBy(xpath = "//a[@id='reset-certification-button']")
    public WebElement resetToDefaultTemplateButton;
    @FindBy(xpath = "//a[text()='Reset']")
    public WebElement resetButton;
    @FindBy(xpath = "//a[@id='delete-button']")
    public WebElement deleteButton;
    @FindBy(xpath = "//div[text()='Operation completed successfully']")
    public WebElement successSaveAsNewMessage;

    public CertificatesPage selectRandomCertificate() {
        select = new Select(certificateDropdown);
        List<WebElement> listOptions = select.getOptions();
        int randomIndex = random.nextInt(listOptions.size());
        select.selectByIndex(randomIndex);
        return this;
    }

    public CertificatesPage uploadOwnCertificate() {
        try {
            File[] filesList = new File(getValue("imagesPath")).listFiles();
            File file = filesList[random.nextInt(filesList.length)];
            String absolutePath = file.getAbsolutePath();
            uploadCertificateButton.sendKeys(absolutePath);
        } catch (NullPointerException npe) {
            npe.getMessage();
        }
        return this;
    }

    public CertificatesPage clickSaveAsNewButton() {
        webElementHelper.click(saveAsNewButton);
        return this;
    }

    public CertificatesPage fillUpCertificateName(){
        webElementHelper.sendKeys(inputCertificateName, getValue("username"));
        return this;
    }

    public CertificatesPage clickSaveCertificateButton() {
        webElementHelper.click(saveCertificateButton);
        return this;
    }
}
