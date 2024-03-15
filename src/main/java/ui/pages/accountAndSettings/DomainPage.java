package ui.pages.accountAndSettings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class DomainPage extends BasePage {

    @FindBy(xpath = "//input[@name='domain_name']")
    public WebElement domainNameInput;
    @FindBy(xpath = "//input[@name='submit_domain_name']")
    public WebElement changeDomainNameButton;
    @FindBy(xpath = "//button[text()='Map a custom domain']")
    public WebElement mapCustomDomainButton;
    @FindBy(xpath = "//a[text()='cancel']")
    public WebElement cancelButton;
    @FindBy(xpath = "//a[text()='Upgrade']")
    public WebElement upgradeButton;
    @FindBy(xpath = "//a[text()='Back to domain name']")
    public WebElement backToDomainNameButton;
    @FindBy(xpath = "//div[text()='Domain name changed']")
    public WebElement successRenameDomainMessage;

    public DomainPage fillUpDomainNameInput(String domain) {
        webElementHelper.sendKeys(domainNameInput, domain);
        return this;
    }

    public DomainPage clickChangeDomainButton() {
        webElementHelper.click(changeDomainNameButton);
        return this;
    }

    public DomainPage clickCancelButton() {
        webElementHelper.click(cancelButton);
        return this;
    }

    public DomainPage clickMapCustomDomainButton() {
        webElementHelper.click(mapCustomDomainButton);
        return this;
    }

    public DomainPage clickUpgradeButton() {
        webElementHelper.click(upgradeButton);
        return this;
    }

    public DomainPage clickBackToDomainNameButton() {
        webElementHelper.click(backToDomainNameButton);
        return this;
    }
}
