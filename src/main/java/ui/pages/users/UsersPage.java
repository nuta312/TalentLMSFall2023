package ui.pages.users;

import ui.entity.User;
import ui.helper.FakeDataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.pages.BasePage;
import java.util.List;

public class UsersPage extends BasePage {

    User randomUser = FakeDataHelper.createNewUserWithFakerData();
    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    public WebElement homeBtn;
    @FindBy(xpath = "(//div[@class='hidden-phone']/child::a)[1]")
    public WebElement homeAddUserBtn;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement firstnameInput;
    @FindBy(xpath = "//input[@name='surname']")
    public WebElement lastnameInput;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInput;
    @FindBy(xpath = "//input[@name='login']")
    public WebElement usernameInput;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;
    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement bioInput;
    @FindBy(xpath = "(//span[@class=\"select2-arrow\"])[1]")
    public WebElement userTypesSelectBtn;
    @FindBy(xpath = "(//span[@class=\"select2-chosen\"])[2]")
    public WebElement timeZoneSelectBtn;
    @FindBy(xpath = "//span[contains(text(),'(Russian)')]")
    public WebElement languageSelectInput;
    @FindBy(xpath = "//input[@id=\"status\"]")
    public WebElement activeCheckbox;
    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement excludeFromEmailsCheckbox;
    @FindBy(xpath = "//input[@name=\"submit_personal_details\"]")
    public WebElement addUserSubmitBtn;
    @FindBy(xpath = "//a[text()='cancel']")
    public WebElement cancelAddUserSubmitBtn;
    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement addUserSuccessMessage;
    @FindBy(xpath = "(//span[@class=\"help-inline\"])[3]")
    public WebElement emailMessage;
    @FindBy(xpath = "(//span[@class=\"help-inline\"])[4]")
    public WebElement userNameMessage;
    @FindBy(xpath = "(//span[@class=\"help-inline\"])[1]")
    public WebElement nameIsRequiredMessage;
    @FindBy(xpath = "(//span[@class=\"help-inline\"])[2]")
    public WebElement lastNameIsRequiredMessage;
    @FindBy(xpath = "(//span[@class=\"help-inline\"])[3]")
    public WebElement emailAddressValidationMessage;
    @FindBy(xpath = "(//span[@class=\"help-inline\"])[2]")
    public WebElement passwordValidationMessage;

    public UsersPage fillUpUserWithFakerData() {
        webElementHelper
                .sendKeys(firstnameInput, randomUser.getFirstname())
                .sendKeys(lastnameInput, randomUser.getLastname())
                .sendKeys(emailInput, randomUser.getEmailAddress())
                .sendKeys(usernameInput, randomUser.getUsername());
        passwordInput.sendKeys("TestTest123!");
        return this;
    }

    public UsersPage selectUserType() {
        webElementHelper.click(userTypesSelectBtn);
        List<WebElement> userTypeDropDown = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath("//div[@id='select2-drop']/ul/li")));
        int randomIndex = random.nextInt(userTypeDropDown.size());
        userTypeDropDown.get(randomIndex).click();
        return this;
    }

    public UsersPage selectTimeZone() {
        webElementHelper.click(timeZoneSelectBtn);
        List<WebElement> timeZoneDropDown = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath("//div[@id='select2-drop']/ul/li")));
        int randomIndex = random.nextInt(timeZoneDropDown.size());
        timeZoneDropDown.get(randomIndex).click();
        return this;
    }

    public UsersPage selectLanguage() {
        webElementHelper.click(languageSelectInput);
        List<WebElement> languageDropDown = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath("//div[@id='select2-drop']/ul/li")));
        int randomIndex = random.nextInt(languageDropDown.size());
        webElementHelper.waitForButtonToBeClickAble(languageSelectInput);
        languageDropDown.get(randomIndex).click();
        return this;
    }

    public UsersPage clickOnExcludeFromEmailsCheckbox() {
        webElementHelper.scrollToElement(excludeFromEmailsCheckbox);
        webElementHelper.click(excludeFromEmailsCheckbox);
        return this;
    }

    public UsersPage clickOnAddUserSubmitBtn() {
        webElementHelper.scrollToElement(activeCheckbox)
                .click(activeCheckbox);
        webElementHelper.scrollToElement(addUserSubmitBtn);
        webElementHelper.click(addUserSubmitBtn);
        return this;
    }
}
