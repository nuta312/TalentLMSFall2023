package ui.pages.accountAndSettings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class SubscriptionPage extends BasePage {

    @FindBy(xpath = "//div[@id='s2id_tl-prices-basedon']")
    public WebElement planTypeButton;
    @FindBy(xpath = "//span[text()='Standard plan']")
    public WebElement StandardPlanButton;
    @FindBy(xpath = "//span[text()='Active plan']")
    public WebElement activePlanButton;
    @FindBy(xpath = "//div[@id='s2id_tl-plans-content']")
    public WebElement includeTalentLibraryButton;
    @FindBy(xpath = "//span[text()='No']")
    public WebElement NoButton;
    @FindBy(xpath = "//div[text()='Yes']")
    public WebElement YesButton;
    @FindBy(xpath = "//div[@id='s2id_tl-plans-commitment']")
    public WebElement billedButton;
    @FindBy(xpath = "//span[text()='Yearly']")
    public WebElement yearlyButton;
    @FindBy(xpath = "//span[text()='Monthly']")
    public WebElement monthlyButton;
    @FindBy(xpath = "(//a[contains(@href,'starter')])[2]")
    public WebElement selectStarterPlanButton;
    @FindBy(xpath = "(//a[contains(@href,'basic')])[4]")
    public WebElement selectBasicPlanButton;
    @FindBy(xpath = "(//a[contains(@href,'plus')])[4]")
    public WebElement selectPlusPlanButton;
    @FindBy(xpath = "(//a[contains(@href,'premium')])[2]")
    public WebElement selectPremiumPlanButton;
    @FindBy(id = "//a[text()='cancel']")
    public WebElement cancelButton;

    public SubscriptionPage clickStarterPlanButton() {
        webElementHelper.click(selectStarterPlanButton);
        return this;
    }

    public SubscriptionPage clickBasicPlanButton() {
        webElementHelper.click(selectBasicPlanButton);
        return this;
    }

    public SubscriptionPage clickPlusPlanButton() {
        webElementHelper.click(selectPlusPlanButton);
        return this;
    }

    public SubscriptionPage clickPremiumPlanButton() {
        webElementHelper.click(selectPremiumPlanButton);
        return this;
    }

    public SubscriptionPage clickCancelButton() {
        webElementHelper.clickWithScrollToElement(cancelButton);
        return this;
    }
}
