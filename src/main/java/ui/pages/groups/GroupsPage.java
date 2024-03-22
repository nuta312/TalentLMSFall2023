package ui.pages.groups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

import static ui.driver.Driver.getDriver;

public class GroupsPage extends BasePage {

    @FindBy(xpath = "(//div[@class='tl-icon-label'])[4]")
    public WebElement groupButton;
    @FindBy(xpath = "//div[@class='tl-header-tools']//a[@class='btn btn-primary']")
    public WebElement addGroupButton;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement inputName;
    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement inputDescription;
    @FindBy(xpath = "//i[@id='icon-key']")
    public WebElement groupKeyButton;
    @FindBy(xpath = "//input[@name='max_redemptions']")
    public WebElement inputRedemptions;
    @FindBy(xpath = "//i[@id='icon-price']")
    public WebElement priceButton;
    @FindBy(xpath = "//input[@name='price']")
    public WebElement priceInput;
    @FindBy(xpath = "//div[@class='form-actions']//div")
    public WebElement addNewGroup;
    @FindBy(xpath = "//span[@class='tl-box-title-options']//a[2]")
    public WebElement backToGroupPage;
    @FindBy(xpath = "//div[@class='toast toast-success']//div[@class='toast-message']")
    public WebElement messageAfterCreateGroup;

    /**
     * edit xpath
     */
    @FindBy(xpath = "(//td[@class=' tl-align-center tl-table-operations-cell'])[1]//i[@alt='Edit']")
    public WebElement hiddenEditButton;
    @FindBy(xpath = "//div[@class='form-actions']/input")
    public WebElement updateButton;
    @FindBy(xpath = "//div[@class='toast toast-success']//div[@class='toast-message']")
    public WebElement messageAfterUpdateGroup;

    /**
     * delete xpath
     */
    @FindBy(xpath = "(//td[@class=' tl-align-center tl-table-operations-cell'])[1]")
    public WebElement navigateMouse;
    @FindBy(xpath = "(//td[@class=' tl-align-center tl-table-operations-cell'])[1]//i[@alt='Delete']")
    public WebElement hiddenDeleteButton;
    @FindBy(xpath = "//a[@id='tl-confirm-submit']")
    public WebElement deleteButton;

    public GroupsPage addGroup() {
        webElementHelper.click(groupButton)
                .click(addGroupButton)
                .sendKeys(inputName, "Team-1")
                .sendKeys(inputDescription, "Bug's Bunny group")
                .click(groupKeyButton)
                .sendKeys(inputRedemptions, "1500")
                .click(priceButton)
                .sendKeys(priceInput, "1500")
                .click(addNewGroup);
        return this;
    }

    public GroupsPage backToMainGroupPageList(){
        webElementHelper.click(backToGroupPage);
        return this;
    }

    public void navigateMouse(){
        webElementHelper.actions = new Actions(getDriver());
        webElementHelper.actions.moveToElement(navigateMouse).build().perform();
    }

    public GroupsPage updateGroup(){
        navigateMouse();
        webElementHelper.click(hiddenEditButton)
                .sendKeys(inputName,"Fall")
                .click(updateButton);
        return this;
    }

    public GroupsPage deleteGroup(){
        navigateMouse();
        webElementHelper.click(hiddenDeleteButton)
                .click(deleteButton);
        return this;
    }
}