package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(xpath = "(//input[@name='domain'])[1]")
    public WebElement domainInput;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Log in']")
    public WebElement loginButton;

    public LoginPage enterDomain(String domain){
        webElementHelper.sendKeys(domainInput, domain);
        return this;
    }

    public LoginPage enterUsername(String text){
        webElementHelper.sendKeys(usernameInput, text);
        return this;
    }

    public LoginPage enterPassword(String password){
        webElementHelper.sendKeys(passwordInput, password);
        return this;
    }

    public LoginPage clickLoginButton(){
        webElementHelper.click(loginButton);
        return this;
    }

}
