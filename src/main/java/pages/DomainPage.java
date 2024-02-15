package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class DomainPage {
    WebDriver driver;

    public DomainPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='domain_name']")
    public WebElement rename;

    @FindBy(xpath = "//label[text()='Domain name']")
    public WebElement DomainName;

    @FindBy(xpath = "//input[@name='submit_domain_name']")
    public WebElement ChangeDomainName;

    @FindBy(xpath = "//div[@id='tl-admin-settings']/div[2]/a[7]")
    public WebElement PathDomain;

    @FindBy(xpath = "//button[text()='Map a custom domain']")
    public WebElement MapACustomDomain;

    @FindBy(xpath = "//div[@class='switch-plus-message']")
    public WebElement PopupWindow;

    @FindBy(xpath = "//span[text()='×']")
    public WebElement DeletePopupWindow;

    @FindBy(xpath = "//a[text()='Upgrade']")
    public WebElement UpgradeClick;

    @FindBy(xpath = "//p[text()='You are registered to the ']")
    public WebElement TrueTextSubscription;

    @FindBy(xpath = "//a[text()='cancel']")
    public WebElement Cancel;

    @FindBy(xpath = "//a[text()='Home']")
    public WebElement ClickHome;


    /**
     * ниже прописанный метод пробный
     */
    public DomainPage AzhanLogin() {
        driver.findElement(By.xpath("//input[@class='login-fields'][@name='login']"))
                .sendKeys("nurik9816");
        driver.findElement(By.xpath("//input[@type='password']"))
                .sendKeys("qwerty12345");
        driver.findElement(By.xpath("//input[@name='submit']"))
                .click();
        return this;
    }

    public DomainPage PathDomain() {
        PathDomain
                .click();
        return this;
    }

    public DomainPage DomainName() {
        String textTrue = DomainName.getText();
        assertEquals(textTrue, "Domain name");
        return this;
    }

    public DomainPage MapACustomDomain() {
        MapACustomDomain
                .click();
        return this;
    }

    public DomainPage PopupWindow() {
        String textTrue = PopupWindow.getText();
        assertEquals(textTrue, "A new beta version of your" +
                " interface is available for your Administrators, Instructors," +
                " and Learners. Learn more and start exploring!");
        DeletePopupWindow.click();
        return this;
    }

    public DomainPage UpgradeClick() {
        UpgradeClick
                .click();
        String trueText = TrueTextSubscription.getText();
        assertEquals(trueText, "You are registered to the Free plan");
        driver.navigate().back();
        DomainName();
        return this;
    }

    public DomainPage Rename() throws InterruptedException {
        rename.clear();
        rename.sendKeys("fall2023");
        Thread.sleep(3000);
        return this;
    }

    public DomainPage CancelClick() {
        Cancel.click();
        driver.navigate().back();
        return this;
    }

    public DomainPage ClickHome() {
        ClickHome.click();
        PathDomain();
        return this;
    }

    public DomainPage ChangeName() throws InterruptedException {
        Rename();
        ChangeDomainName
                .click();
        return this;
    }

    public DomainPage ReturnToDomain(){
        AzhanLogin();
        PathDomain();
        return this;
    }


}
