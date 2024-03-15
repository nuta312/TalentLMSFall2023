package ui.pages.accountAndSettings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;
import java.io.File;

import static config.ConfigReader.getValue;

public class BasicSettingsPage extends BasePage {

    @FindBy(xpath = "//input[@name='site_description']")
    public WebElement siteDescriptionInput;
    @FindBy(xpath = "//input[@name='logo_uploader']")
    public WebElement selectLogoButton;
    @FindBy(css = "#tl-crop-modal-logo > div.modal-footer > button")
    public WebElement applyLogoButton;
    @FindBy(xpath = "//input[@name='favicon_uploader']")
    public WebElement selectFaviconButton;
    @FindBy(css = "#tl-crop-modal-favicon > div.modal-footer > button")
    public WebElement applyFaviconButton;
    @FindBy(xpath = "//select[@name='default_language']")
    public WebElement languageButton;
    @FindBy(xpath = "//select[@name='default_timezone']")
    public WebElement timeZoneButton;
    @FindBy(xpath = "//select[@name='date_format']")
    public WebElement dateFormatButton;
    @FindBy(xpath = "//select[@name='time_format']")
    public WebElement timeFormatButton;
    @FindBy(xpath = "//select[@name='currency']")
    public WebElement currencyButton;
    @FindBy(xpath = "//select[@name='conference_mode']")
    public WebElement conferenceTypeButton;
    @FindBy(xpath = "//input[@name='conference_max_users']")
    public WebElement capacityInput;
    @FindBy(xpath = "//input[@name='submit']")
    public WebElement saveButton;
    @FindBy(xpath = "//div[text()='Basic settings updated successfully']")
    public WebElement successSavingMessage;

    public BasicSettingsPage fillUpDescription(String text) {
        webElementHelper.sendKeys(siteDescriptionInput, text);
        return this;
    }

    public BasicSettingsPage selectRandomLogo() {
        try {
            File[] filesList = new File(getValue("imagesPath")).listFiles();
            File file = filesList[random.nextInt(filesList.length)];
            String absolutePath = file.getAbsolutePath();
            selectLogoButton.sendKeys(absolutePath);
            webElementHelper.click(applyLogoButton);
        } catch (NullPointerException npe) {
            npe.getMessage();
        }
        return this;
    }

    public BasicSettingsPage selectRandomFavicon() throws InterruptedException {
        try {
            File[] filesList = new File(getValue("imagesPath")).listFiles();
            File file = filesList[random.nextInt(filesList.length)];
            String absolutePath = file.getAbsolutePath();
            selectFaviconButton.sendKeys(absolutePath);
            webElementHelper.click(applyFaviconButton);
        } catch (NullPointerException npe) {
            npe.getMessage();
        }
        Thread.sleep(1500);
        return this;
    }

    public BasicSettingsPage selectLanguage() {
        webElementHelper.scrollDownPage();
        dropdownHelper.selectByText(languageButton, "Pусский (Russian)");
        return this;
    }

    public BasicSettingsPage selectTimeZone() {
        dropdownHelper.selectByText(timeZoneButton, "(GMT +06:00) Almaty");
        return this;
    }

    public BasicSettingsPage selectDateFormat() {
        dropdownHelper.selectByText(dateFormatButton, "DD/MM/YYYY");
        return this;
    }

    public BasicSettingsPage selectTimeFormat() {
        dropdownHelper.selectByText(timeFormatButton, "24-hour");
        return this;
    }

    public BasicSettingsPage selectCurrency() {
        dropdownHelper.selectByText(currencyButton, "Russian Ruble");
        return this;
    }

    public BasicSettingsPage selectConferenceMode() {
        webElementHelper.scrollDownPage();
        dropdownHelper.selectByText(conferenceTypeButton, "Zoom Meeting");
        return this;
    }

    public BasicSettingsPage inputCapacity() {
        capacityInput.sendKeys("10");
        return this;
    }

    public BasicSettingsPage clickSaveChanges() {
        webElementHelper.click(saveButton);
        return this;
    }
}
