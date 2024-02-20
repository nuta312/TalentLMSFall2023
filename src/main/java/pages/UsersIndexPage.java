package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class UsersIndexPage extends BasePage{
    @FindBy(xpath = "//select [@id='tl-signup']")
    public WebElement selectSignUp;

    @FindBy(xpath="//select[@name='default_type']")
    public WebElement selectDefaultUserType;

    @FindBy(xpath = "//select[@name='default_group']")
    public WebElement selectDefaultGroup;

    @FindBy(id = "control-group-show-password")
    public WebElement passwordSetting;

    @FindBy (id = "strong_passwords")
    public WebElement checkboxStrongPasswords;

    @FindBy(xpath = "//div[@id='tl-password-change-days']/div/label")
    public WebElement checkboxPasswordChange;

    @FindBy(xpath = "//div[@id='tl-password-change-days']/div/div/input")
    public WebElement inputDays;

    @FindBy(xpath = "//div[@class='controls tl-outer-control-group well']/div[3]/div")
    public WebElement checkboxChangePassword;

    @FindBy(xpath = "//div[@id='tl-password-lock-login-retry']/div/label")
    public WebElement checkboxLockAccount;

    @FindBy(xpath = "//div[@id='tl-password-lock-login-retry']/div/div/input[@id='lock_login_retry_attempts']")
    public WebElement inputFailedAttempts;

    @FindBy(xpath = "//div[@id='tl-password-lock-login-retry']/div/div[2]/input[@id='lock_login_retry_minutes']")
    public WebElement inputFailedAttemptsPerMinutes;

    @FindBy(xpath = "//fieldset/div[7]/div/a")
    public WebElement hidenTermOfService;

    @FindBy(xpath = "//fieldset/div[8]/div/div/div/textarea")
    public WebElement inputText;


    @FindBy(xpath = "//fieldset/div[9]/div/a")
    public WebElement visibleUserFormat;

    @FindBy(xpath= "//select[@name='user_format']")
    public WebElement selectUserName;

    @FindBy(xpath = "//fieldset/div[11]/div/a")
    public WebElement hidenSocialOptions;

    @FindBy(xpath = "//div[@id='social-signup-group']/div/label")
    public WebElement checkboxSocialMedia;

    @FindBy(xpath = "//div[@id='social-signup-group']/div/label[2]")
    public WebElement checkboxCatalog;

    @FindBy(xpath = "//div[@id='social-signup-group']/div/label[3]")
    public WebElement checkboxLknCertificate;

    @FindBy(xpath = "//div[@id='social-signup-group']/div/label[4]")
    public WebElement checkboxCourseRating;

    @FindBy(xpath = "//div[@class='form-actions']/input")
    public WebElement saveBtn;

    @FindBy(xpath = "//div[@class='form-actions']/span")
    public WebElement cancelBtn;

    public UsersIndexPage fillSelectSignUp(){
        Select select = new Select(selectSignUp);
        List<WebElement> options=select.getOptions();
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        select.selectByIndex(randomIndex);
        return this;
    }

    public UsersIndexPage fillSelectDefaultUserType(){
        Select select = new Select(selectDefaultUserType);
        List<WebElement> options=select.getOptions();
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        select.selectByIndex(randomIndex);
        return this;
    }

    public UsersIndexPage fillSelectDefaultGroup(){
        Select select = new Select(selectDefaultGroup);
        List<WebElement> options = select.getOptions();
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        select.selectByIndex(randomIndex);
        return this;
    }

    public UsersIndexPage clickPasswordSetting(){
        webElementHelper.click(passwordSetting);
        return this;
    }

    public UsersIndexPage fillCheckboxStrongPasswords(){
        webElementHelper.click(checkboxStrongPasswords);

        return this;
    }
    public UsersIndexPage fillCheckboxChangePassword(){
        webElementHelper.click(checkboxPasswordChange);
        return this;
    }


    public UsersIndexPage fillInputDays(){
        boolean retry = true;
        int attempts = 0;
        try {

            inputDays.click();
            inputDays.sendKeys("12");

        } catch (ElementNotInteractableException e) {
            checkboxChangePassword.click();
            inputDays.click();
            inputDays.sendKeys("12");
        }
        return this;
    }


    public UsersIndexPage fillCheckboxPasswordChange() {
        webElementHelper.click(checkboxPasswordChange);
        return this;
    }
    public UsersIndexPage fillCheckboxLockAccount(){
        webElementHelper.click(checkboxLockAccount);
        return this;
    }
    public UsersIndexPage fillInputFailedAttempts (){
        boolean retry = true;
        int attempts = 0;
        try {
            inputFailedAttempts.click();
            webElementHelper.sendKeys(inputFailedAttempts, "5");
        } catch (TimeoutException e){
            checkboxLockAccount.click();
            webElementHelper.sendKeys(inputFailedAttempts, "5");
        }
        return this;
    }

    public UsersIndexPage fillInputFailedAttemptsPerMinutes (){
        webElementHelper.sendKeys(inputFailedAttemptsPerMinutes, "2");
        return this;
    }
    public UsersIndexPage clickTermOfService (){
        webElementHelper.clickWithScrollToElement(hidenTermOfService);
        return this;
    }
    public UsersIndexPage fillInputText (){
        webElementHelper.sendKeys(inputText, "best group of the word");
        return this;
    }
    public UsersIndexPage fillVisibleUserFormat (){

        webElementHelper.waitForElementToBeDisplayed(visibleUserFormat).clickWithScrollToElement(visibleUserFormat);
        return this;
    }
    public UsersIndexPage fillSelectUserName () {
        Select select = new Select(selectUserName);
        List<WebElement> options = select.getOptions();
        Random random = new Random();
        int randomIndexU = random.nextInt(options.size());

        try {
            select.selectByIndex(randomIndexU);
        } catch (ElementNotInteractableException e){
            webElementHelper.waitForButtonToBeClickAble(visibleUserFormat);
        }
        return this;
    }
    public UsersIndexPage clickOnHidenSocialOptions(){
        webElementHelper.clickWithScrollToElement(hidenSocialOptions);
        return this;
    }

    public UsersIndexPage fillCheckboxSocialMedia (){
        try {
            webElementHelper.waitForButtonToBeClickAble(checkboxSocialMedia);
        }   catch (WebDriverException e){
            webElementHelper.click(hidenSocialOptions);
        }
        return this;
    }
    public UsersIndexPage fillCheckboxCatalog (){
        webElementHelper.clickWithScrollToElement(checkboxCatalog);
        return this;
    }

    public UsersIndexPage fillCheckboxLknCertificate (){
        webElementHelper.clickWithScrollToElement(checkboxLknCertificate);
        return this;
    }

    public UsersIndexPage fillCheckboxCourseRating (){
        webElementHelper.clickWithScrollToElement(checkboxCourseRating);
        return this;
    }

    public UsersIndexPage fillSaveBtn (){
        saveBtn.submit();
        return this;
    }

    public UsersIndexPage fillCancelBtn (){
        webElementHelper.scrollToElement(cancelBtn);
        return this;
    }


}
